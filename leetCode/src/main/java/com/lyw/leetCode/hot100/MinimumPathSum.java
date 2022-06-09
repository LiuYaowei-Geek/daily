package com.lyw.leetCode.hot100;
//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics Array Dynamic Programming Matrix 
// 👍 6878 👎 94

/**
  * questionId：64
  * question：Minimum Path Sum
  * date：2022-03-12 17:33:02
*/
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        //特殊值处理
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //行
        int row = grid.length;
        //列
        int col = grid[0].length;
        //i代表行数，遍历行
        for (int i = 0; i < row; i++) {
            //j代表列数，遍历列
            for (int j = 0; j < col; j++) {
                //当前位子左边的值
                int leftSum = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                //当前位置上边的值
                int topSum = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                //起始位置处理
                if (i == 0 && j == 0) {
                    continue;
                }
                //取左边和上边最小值进行累加，每次都取最小的，最终值就是最小的
                grid[i][j] += Math.min(leftSum, topSum);
            }
        }
        return grid[row - 1][col - 1];
    }

    public int minPathSumWithDp(int[][] grid) {
        //Use a 2D array named memo to remember value which is calculated before to speed up
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    private int minPathSumHelper(int[][] grid, int row, int col, int[][]memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;

        if (row < grid.length - 1) {
            rowInc = minPathSumHelper(grid, row + 1, col, memo);
        }
        if (col < grid[0].length - 1) {
            colInc = minPathSumHelper(grid, row, col + 1, memo);
        }
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
