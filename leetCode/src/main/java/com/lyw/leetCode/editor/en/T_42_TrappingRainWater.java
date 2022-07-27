//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 20359 👎 284


package com.lyw.leetCode.editor.en;

//Java：T_42_Trapping Rain Water
public class T_42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new T_42_TrappingRainWater().new Solution();
        // TO TEST
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         * 对于left位置，当前leftMax <= rightMax时，left位置雨水容积固定为 leftMax-height[left];
         * 对于right位置，当前leftMax > rightMax时，right位置雨水容积固定为 rightMax-height[right];
         */
        public int trap(int[] height) {
            //数组长度小于3时，不能容积雨水
            if (height.length < 3) {
                return 0;
            }
            //left初始化为1
            int left = 1, right = height.length - 1;
            int leftMax = height[0], rightMax = height[height.length - 1];
            int sum = 0;
            //条件为left <= right，不然会少累积数据eg:{4,2,3}
            //对于left位置，当前leftMax <= rightMax时，left位置雨水容积固定为leftMax-height[left];
            //对于right位置，当前leftMax > rightMax时，right位置雨水容积固定为rightMax-height[right];
            while (left <= right) {
                if (leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, height[left]);
                    sum += leftMax - height[left];
                    left++;
                } else {
                    rightMax = Math.max(rightMax, height[right]);
                    sum += rightMax - height[right];
                    right--;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}