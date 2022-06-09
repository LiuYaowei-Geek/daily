package com.lyw.leetCode.hot100;
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '
//0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matri
//x 
// 👍 12949 👎 318

/**
  * questionId：200
  * question：Number of Islands
  * date：2022-03-25 10:27:06
*/
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //二维数组行大小
    private int n;
    //二维数组列大小
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //当前格子为1时，把这个格子相连的所有格子标记为0
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    //遇到1就count++
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * grid[i][j] == '1'
     * 当前格子为1时，把这个格子相连的所有格子标记为0，使用递归实现相连的所有格子都标记
     * @param grid
     * @param i
     * @param j
     */
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        //标记下面的格子
        DFSMarking(grid, i + 1, j);
        //标记上面的格子
        DFSMarking(grid, i - 1, j);
        //标记右边的格子
        DFSMarking(grid, i, j+1);
        //标记左边的格子
        DFSMarking(grid, i, j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
