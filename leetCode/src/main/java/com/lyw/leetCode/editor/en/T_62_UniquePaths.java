//There is a robot on an m x n grid. The robot is initially located at the top-l
//eft corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corne
//r (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at an
//y point in time. 
//
// Given the two integers m and n, return the number of possible unique paths th
//at the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal to
// 2 * 109. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach th
//e bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
// Related Topics Math Dynamic Programming Combinatorics 
// 👍 8664 👎 295


package com.lyw.leetCode.editor.en;

import java.util.Arrays;

//Java：T_62_Unique Paths
public class T_62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new T_62_UniquePaths().new Solution();
        // TO TEST
        System.out.println(solution.uniquePaths(3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }
            int[][] dp = new int[m][n];
            //初始化dp，第一行第一列值都初始化为1
            //由于非第一行第一列的数据在遍历时会重新计算，所以偷懒初始整个数组为1
            Arrays.fill(dp[0], 1);
            Arrays.fill(dp, dp[0]);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    //由于只能向左或者向下走，所以状态状态方程为dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                    //当前格子的值等于它上方格子的值加上它左边格子的值
                    //因为当前格子只能由它上方的格子往下走或者它左边的格子往右走
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

        public int uniquePaths2(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}