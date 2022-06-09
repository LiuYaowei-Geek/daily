package com.lyw.leetCode.hot100;
//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 13582 👎 835

/**
  * questionId：11
  * question：Container With Most Water
  * date：2022-01-09 23:10:40
*/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * timeout
         * @param height
         * @return
         */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

        /**
         * 1、Start with pointer left=0 and pointer right=length-1
         * 2、The max water is limited by the pointer with smaller height
         * 3、When moving a pointer, the width of the area decrease
         * 4、If we move the pointer with higher height, we will never get a greater area, the max height will be at most the one of the pointer with smaller height.
         * S5、o we need to move the pointer with smaller height to have a chance to get higher height at the next step.
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            //max is the result
            //left is the left pointer
            //right is the right pointer
            int max = 0, left = 0, right = height.length - 1;
            while(left < right) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
