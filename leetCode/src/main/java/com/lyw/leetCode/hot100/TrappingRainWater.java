package com.lyw.leetCode.hot100;
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
// 👍 17088 👎 243

import java.util.Stack;

/**
  * questionId：42
  * question：Trapping Rain Water
  * date：2022-03-08 21:38:12
*/
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int water = 0, i = 0;
        while (i < height.length) {
            //数组中，当前位子值比它前一个位子值小
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            //数组中，当前位子值比它前一个位子值大
            } else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    // find the smaller height between the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    // calculate the area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
