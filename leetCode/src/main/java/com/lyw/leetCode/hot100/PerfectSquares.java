package com.lyw.leetCode.hot100;
//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-First Search 
// 👍 6524 👎 289

import java.util.Arrays;

/**
  * questionId：279
  * question：Perfect Squares
  * date：2022-04-06 12:58:48
*/
public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(13));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j*j <= n ; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
