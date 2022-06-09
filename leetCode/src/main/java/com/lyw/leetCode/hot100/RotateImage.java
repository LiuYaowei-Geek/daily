package com.lyw.leetCode.hot100;
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
// 👍 8324 👎 462

import java.util.Arrays;

/**
  * questionId：48
  * question：Rotate Image
  * date：2022-03-09 08:35:55
*/
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] matrix = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println(matrix.length);
        solution.rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //二维数据旋转90度
    public void rotate(int[][] matrix) {
        //先把列数据转为行数据
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //反转每一行数据
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
