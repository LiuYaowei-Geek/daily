//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 7054 👎 828


package com.lyw.leetCode.editor.en.matrix;


import java.util.ArrayList;
import java.util.List;

//Java：T_54_Spiral Matrix
public class T_54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new T_54_SpiralMatrix().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix));
        System.out.println(solution.spiralOrder2(matrix));
        System.out.println(solution.spiralOrder3(matrix));
        System.out.println(solution.spiralOrder4(matrix));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //每一圈按照上下左右遍历，然后移动边界值，遍历过程中需要注意拐点位置不能重复添加
        //从右往左和从下往上遍历时需要添加(list.size() < max)或者(top < bottom && left<right)的判断，避免矩阵为长方形时从右往左和从下往上加数据时加重复
        //因为每次都是先往右走和先往下走，所以往右走和往下走的路一定是没走过的路，不需要加if判断；往左走的时候，如果top == bottom，那么会重复走之前从左往右走过的路，所以需要加上top < bottom的判断，同理往上走也一样。
        //时间复杂度O(mn)， 空间复杂度O(1)
        //每条边界遍历完进行边界移动
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            //定义上下左右边界位置
            int left = 0;
            int right = matrix[0].length;
            int top = 0;
            int bottom = matrix.length;

            int max = matrix.length * matrix[0].length;

            //从外到内进行遍历，没条边界遍历完后进行数值增减。注意拐点位置不能重复添加
            while (list.size() < max) {
                //从左遍历到右
                for (int i = left; i < right; i++) {
                    list.add(matrix[top][i]);
                }
                //上边界加一
                top++;
                //从上到下遍历
                for (int i = top; i < bottom; i++) {
                    list.add(matrix[i][right - 1]);
                }
                //右边界移动
                right--;
                //从右往左遍历
                //重要，需要添加list.size() < max的判断，避免矩阵为长方形时从右往左和从下往上加数据时加重复
                for (int i = right - 1; i >= left && list.size() < max; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
                //下边界移动
                bottom--;
                //从下到上遍历
                //重要，需要添加list.size() < max的判断，避免矩阵为长方形时从右往左和从下往上加数据时加重复
                for (int i = bottom - 1; i >= top && list.size() < max; i--) {
                    list.add(matrix[i][left]);
                }
                //左边界移动
                left++;
            }
            return list;
        }

        //全部边界遍历完进行边界移动
        public List<Integer> spiralOrder2(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            //定义上下左右边界位置
            int left = 0;
            int right = matrix[0].length;
            int top = 0;
            int bottom = matrix.length;

            int max = matrix.length * matrix[0].length;


            //从外到内进行遍历，没条边界遍历完后进行数值增减。注意拐点位置不能重复添加
            while (list.size() < max) {
                //从左遍历到右
                for (int i = left; i < right; i++) {
                    list.add(matrix[top][i]);
                }
                //从上到下遍历
                for (int i = top + 1; i < bottom; i++) {
                    list.add(matrix[i][right - 1]);
                }
                //从右往左遍历
                for (int i = right - 2; i >= left && list.size() < max; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
                //从下到上遍历
                for (int i = bottom - 2; i >= top + 1 && list.size() < max; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return list;
        }

        //全部边界遍历完进行边界移动
        public List<Integer> spiralOrder3(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            //定义上下左右边界位置
            int left = 0;
            int right = matrix[0].length;
            int top = 0;
            int bottom = matrix.length;


            //矩阵为长方形时，最后一行的数据会加重
            while (left < right && top < bottom) {
                //从左遍历到右
                for (int i = left; i < right; i++) {
                    list.add(matrix[top][i]);
                }
                //从上到下遍历
                for (int i = top + 1; i < bottom; i++) {
                    list.add(matrix[i][right - 1]);
                }
                //从右往左遍历
                for (int i = right - 2; i >= left && top < bottom - 1; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
                //从下到上遍历
                for (int i = bottom - 2; i >= top + 1 && left < right - 1; i--) {
                    list.add(matrix[i][left]);
                }
                left++;right--;top++;bottom--;
            }
            return list;
        }


        public List<Integer> spiralOrder4(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            //定义上下左右边界位置
            int left = 0;
            int right = matrix[0].length;
            int top = 0;
            int bottom = matrix.length;


            //从外到内进行遍历，没条边界遍历完后进行数值增减。注意拐点位置不能重复添加
            while (left < right && top < bottom) {
                //从左遍历到右
                for (int i = left; i < right; i++) {
                    list.add(matrix[top][i]);
                }
                //上边界加一
                top++;
                //从上到下遍历
                for (int i = top; i < bottom; i++) {
                    list.add(matrix[i][right - 1]);
                }
                //右边界移动
                right--;
                //从右往左遍历
                //重要，需要添加list.size() < max的判断，避免矩阵为长方形时从右往左和从下往上加数据时加重复
                for (int i = right - 1; i >= left && top < bottom; i--) {
                    list.add(matrix[bottom - 1][i]);
                }
                //下边界移动
                bottom--;
                //从下到上遍历
                //重要，需要添加list.size() < max的判断，避免矩阵为长方形时从右往左和从下往上加数据时加重复
                for (int i = bottom - 1; i >= top && left < right; i--) {
                    list.add(matrix[i][left]);
                }
                //左边界移动
                left++;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}