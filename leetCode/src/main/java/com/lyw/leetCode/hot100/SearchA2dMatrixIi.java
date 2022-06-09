package com.lyw.leetCode.hot100;
//Write an efficient algorithm that searches for a value target in an m x n inte
//ger matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matrix[i][j] <= 109 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search Divide and Conquer Matrix 
// 👍 7040 👎 121

/**
  * questionId：240
  * question：Search a 2D Matrix II
  * date：2022-03-31 22:52:56
*/
public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        System.out.println(solution.searchMatrix(new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {21,22,23,24,25}}, 15));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * [1, 2, 3, 4, 5],
         * [6, 7, 8, 9, 10],
         * [11,12,13,14,15],
         * [16,17,18,19,20],
         * [21,22,23,24,25]
         * @param matrix
         * @param target
         * @return
         */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        //从右上角开始找
        while(col >= 0 && row <= matrix.length-1) {
            //相等直接返回
            if(target == matrix[row][col]) {
                return true;
                //小的话列减一
            } else if(target < matrix[row][col]) {
                col--;
                //大的话行家1
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
