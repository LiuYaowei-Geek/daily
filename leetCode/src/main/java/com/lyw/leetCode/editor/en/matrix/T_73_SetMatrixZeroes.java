//Given an m x n integer matrix matrix, if an element is 0, set its entire row a
//nd column to 0's. 
//
// You must do it in place. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
//
// 
// Follow up: 
//
// 
// A straightforward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array Hash Table Matrix 
// 👍 6842 👎 486


package com.lyw.leetCode.editor.en.matrix;

import java.util.Arrays;

//Java：T_73_Set Matrix Zeroes
public class T_73_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new T_73_SetMatrixZeroes().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 标价数据，标记行和列，两次遍历。时间复杂度O(mn)， 空间复杂度O(m+n)
         * <p>
         * 1. 初始化标记数组，有0的位子，将对应行位子和列位子的标记数据设置为true
         * 2.根据标记数组将矩阵中值设置为0，标记数组行或列为true的位子将矩阵中的值设置为0
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return;
            }
            //标记行
            boolean[] row = new boolean[matrix.length];
            //标记列
            boolean[] col = new boolean[matrix[0].length];

            //初始化标记数组，有0的位子，将对应行位子和列位子的标记数据设置为true
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }
            //根据标记数组将矩阵中值设置为0，标记数组行或列为true的位子将矩阵中的值设置为0
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (col[j] || row[i]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        /**
         * 使用数组第一行和第一列当作标记数组，矩阵遍历处理时从第二行和第二列开始遍历，同时维护两个变量记录第一行和第一列是否需要置为0
         * 时间复杂度O(mn)， 空间复杂度O(1)
         *
         * @param matrix
         */
        public void setZeroes2(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return;
            }
            //行是否要置为0
            boolean row = false;
            //列是否要置为0
            boolean col = false;

            //设置row的值
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                    break;
                }
            }

            //设置col的值
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    col = true;
                }
            }

            //第一次遍历，设置标记数组
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }

            //第一次遍历，根据标记数组将矩阵的值设置为0
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            //还原矩阵第一行和第一列数据
            if (row) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (col) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }


        //优化方法2，仅用第一列是否存在0作为变量
        public void setZeroes3(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            boolean col = false;

            //第一次遍历
            for (int i = 0; i < m; i++) {
                //表示第一列是否存在0
                if (matrix[i][0] == 0) {
                    col = true;
                }
                //从第二列开始遍历，如果矩阵当前位子等于0，将其行头和列头设置为0，类似方法二使用第一行第一列作为标记数组
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }

            //第二次遍历
            //矩阵第一行第一列是标记数组，因为是根据第一行和第一列数据进行判断，为避免第一行数据被更新，影响后续列数据的判断，所以从最后一行往第一行进行遍历
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                //根据第一列标识，判断是否将第一列设置为0
                if (col) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}