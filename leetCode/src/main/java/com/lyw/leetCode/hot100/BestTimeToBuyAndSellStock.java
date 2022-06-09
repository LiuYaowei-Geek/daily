package com.lyw.leetCode.hot100;
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
// 👍 14954 👎 503

/**
  * questionId：121
  * question：Best Time to Buy and Sell Stock
  * date：2022-03-20 10:03:57
*/
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[] {7,6,4,3,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
