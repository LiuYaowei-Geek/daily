//You are given an integer array coins representing coins of different denominat
//ions and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If th
//at amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 
// 👍 10951 👎 265


package com.lyw.leetCode.editor.en.dp;

import java.util.Arrays;

//Java：T_322_Coin Change
public class T_322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new T_322_CoinChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划，时间复杂度O(sn),s是金额数amount，n是coins长度  空间复杂度O(s)，dp数组占用
        public int coinChange(int[] coins, int amount) {
            //base case
            if (coins == null || coins.length < 1 || amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            //状态：金额amount
            //转移：一个硬币的金额在coins中数组中遍历
            //硬币最小金额为1，最大状态数：0到amount共amount+1种类
            //dp[i]：i金额最少需要多少个硬币
            int[] dp = new int[amount + 1];
            //找最小值，所以初始话为最大值，比amount大就可以，使用Integer.MAX_VALUE会整数溢出
            Arrays.fill(dp, amount + 1);
            //金额0需要0个硬币
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    //coin需要小于金额i
                    if (coin <= i) {
                        //状态转移方程
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}