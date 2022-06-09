package com.lyw.leetCode.hot100;
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
// 👍 8185 👎 282

/**
  * questionId：62
  * question：Unique Paths
  * date：2022-03-12 16:08:52
*/
public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 3行7列为例子
     *
     * 1   1   1   1   1   1   1
     * 1   2   3   4   5   6   7
     * 1   3   6   10  15  21  28
     *
     * @param m 行
     * @param n 列
     * @return
     */
    public int uniquePaths(int m, int n) {
        //m行 n列构造二维数组
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //第一行和第一列的位子都只有一种走法
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    //非第一行和第一列的数据，当前位子的走法等于它左边位子的走法加上上边位子的走法。（因为题目只能往右或者下走）
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        //右下角值
        return grid[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
