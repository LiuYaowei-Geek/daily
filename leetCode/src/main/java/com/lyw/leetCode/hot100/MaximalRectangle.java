package com.lyw.leetCode.hot100;
//Given a rows x cols binary matrix filled with 0's and 1's, find the largest re
//ctangle containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: matrix = [["1"]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// rows == matrix.length 
// cols == matrix[i].length 
// 1 <= row, cols <= 200 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Dynamic Programming Stack Matrix Monotonic Stack 
// 👍 6466 👎 106

import java.util.Arrays;

/**
  * questionId：85
  * question：Maximal Rectangle
  * date：2022-04-16 13:09:52
*/
public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * matrix
     * 0 0 0 1 0 0 0
     * 0 0 1 1 1 0 0
     * 0 1 1 1 1 1 0
     *
     * height
     * 0 0 0 1 0 0 0
     * 0 0 1 2 1 0 0
     * 0 1 2 3 2 1 0
     *
     * left
     * 0 0 0 3 0 0 0
     * 0 0 2 3 2 0 0
     * 0 1 2 3 2 1 0
     *
     * right
     * 7 7 7 4 7 7 7
     * 7 7 5 4 5 7 7
     * 7 6 5 4 5 4 7
     *
     * result
     * 0 0 0 1 0 0 0
     * 0 0 3 2 3 0 0
     * 0 5 6 3 6 5 0
     *
     * we start from the first row, and move downward;
     * height[i] record the current number of countinous '1' in column i;
     * left[i] record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[i];
     * right[i] record the right most index j which satifies that for any index k from i to  j, height[k] >= height[i];
     * by understanding the definition, we can easily figure out we need to update maxArea with value (height[i] * (right[i] - left[i] + 1));
     *
     * Then the question is how to update the array of height, left, and right
     * =================================
     * for updating height, it is easy
     * for (int j = 0; j < n; j++) {
     *    if (matrix[i][j] == '1') height[j]++;
     *    else height[j] = 0;
     * }
     * =============================================================================
     * It is a little bit tricky for initializing and updating left and right array
     * for initialization:
     * we know initially, height array contains all 0, so according to the definition of left and right array, left array should contains all 0, and right array should contain all n - 1
     * for updating left and right, it is kind of tricky to understand...
     *     ==============================================================
     *     Here is the code for updating left array, we scan from left to right
     *     int lB = 0;  //lB is indicating the left boundry for the current row of the matrix (for cells with char "1"), not the height array...
     *     for (int j = 0; j < n; j++) {
     *          if (matrix[i][j] == '1') {
     *              left[j] = Math.max(left[j], lB); // this means the current boundry should satisfy two conditions: within the boundry of the previous height array, and within the boundry of the current row...
     *          } else {
     *              left[j] = 0; // when matrix[i][j] = 0, height[j] will get update to 0, so left[j] becomes 0, since all height in between 0 - j satisfies the condition of height[k] >= height[j];
     *              lB = j + 1; //and since current position is '0', so the left most boundry for next "1" cell is at least j + 1;
     *          }
     *     }
     *     ==============================================================
     *     the idea for updating the right boundary is similar, we just need to iterate from right to left
     *     int rB = n - 1;
     *     for (int j = n - 1; j >= 0; j--) {
     *         if (matrix[i][j] == '1') {
     *              right[j] = Math.min(right[j], rB);
     *         } else {
     *              right[j] = n - 1;
     *              rB = j - 1;
     *      }
     */
    //https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n - 1);
        for (int i = 0; i < m; i++) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }
            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
