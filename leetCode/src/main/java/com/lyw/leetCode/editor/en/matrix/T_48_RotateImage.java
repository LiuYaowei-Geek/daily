//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array Math Matrix 
// 👍 9012 👎 478


package com.lyw.leetCode.editor.en.matrix;

import java.util.Arrays;

//Java：T_48_Rotate Image
public class T_48_RotateImage {
    public static void main(String[] args) {
        Solution solution = new T_48_RotateImage().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        solution.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度O(n^2)，空间复杂度O(1)
         * 两种方法
         * 1. 先把每列数据旋转(头尾交换)，再将每一行数据和每一列数据交互即可
         * 2. 先把列数据转换为行数据，再反转每一列数据
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            //遍历一半行就够了。不然会重复计算
            for (int i = 0; i < m / 2; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[m - i - 1][j];
                    matrix[m - i - 1][j] = temp;
                }
            }

            for (int i = 0; i < m; i++) {
                //j起始值为i，避免重复计算
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    /**
     * 123
     * 456
     * 789
     *
     * 789
     * 456
     * 123
     *
     * 741
     * 856
     * 923
     *
     * 741
     * 852
     * 963
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}