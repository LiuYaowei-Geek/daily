//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 
// 👍 11484 👎 355


package com.lyw.leetCode.editor.en.dp;

//Java：T_70_Climbing Stairs
public class T_70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new T_70_ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划，时间复杂度O(n) 空间复杂度O(1)
        //dp[i] = dp[i-1] + dp[i-2]
        //当前位置最后一步有两种走法，走一步(dp[i-1])或两步(dp[i-2])。所以状态方程为dp[i] = dp[i-1] + dp[i-2]
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
        /**
         * 1 2 3 4
         * 1 2 3 5
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}