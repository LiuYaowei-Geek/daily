package com.lyw.leetCode.hot100;
//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 105 
// 0 <= heights[i] <= 104 
// 
// Related Topics Array Stack Monotonic Stack 
// 👍 9607 👎 142

import java.util.Stack;

/**
  * questionId：84
  * question：Largest Rectangle in Histogram
  * date：2022-04-16 13:02:21
*/
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // idx of the first bar the left that is lower than current
        int[] lessFromLeft = new int[heights.length];
        // idx of the first bar the right that is lower than current
        int[] lessFromRight = new int[heights.length];
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 0; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/short-and-clean-on-stack-based-java-solution
    public int largestRectangleAreaWithStack(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            int h = i == n ? 0 : heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = curHeight * (i - prevIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
