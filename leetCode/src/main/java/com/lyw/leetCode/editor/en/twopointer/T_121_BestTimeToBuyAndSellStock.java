//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 15724 👎 527


package com.lyw.leetCode.editor.en.twopointer;
//Java：T_121_Best Time to Buy and Sell Stock
public class T_121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new T_121_BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //双指针，时间复杂度O(n), 空间复杂度O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //利润
        int res = 0;
        //双指针，p1指向买入时间，p2指向卖出时间
        int p1 = 0, p2 = 1;
        while (p2 < prices.length) {
            //当卖出值大于买入值时，计算最大利润，并右移卖出时间
            if (prices[p2] > prices[p1]) {
                res = Math.max(res, prices[p2] - prices[p1]);
                p2++;
            } else {
                //当卖出值小于等于买入值时，买入时间替换为卖出时间，卖出时间等于买入时间加1
                p1 = p2;
                p2 = p1 + 1;
            }
        }
        return res;
    }

    //时间复杂度O(n), 空间复杂度O(1)
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //利润
        int res = 0;
        //记录最小值
        int minValue = Integer.MAX_VALUE;
        for (int cur : prices) {
            //记录最小值，cur是当前值
            minValue = Math.min(cur, minValue);
            //计算最大利润
            res = Math.max(cur - minValue, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}