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
// 👍 16604 👎 941


package com.lyw.leetCode.editor.en.twopointer;

//Java：T_11_Container With Most Water
public class T_11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new T_11_ContainerWithMostWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针，时间复杂度O(n)  空间复杂度O(1)
        //双指针，从头和尾一起遍历
        //当左指针高度小于右指针高度时，右移左指针。右指针类似
        //移动左右指针中较小的一个是因为，以数值小的指针为边界，已经是最大的容积了，移动数值大的指针无意义，所以每次移动数值较小的指针
        public int maxArea(int[] heights) {
            if (heights == null || heights.length < 2) {
                return 0;
            }
            //双指针，头尾一起遍历
            int area = 0, left = 0, right = heights.length - 1;

            while (left < right) {
                //计算狂赌
                int width = right - left;
                //取左右指针中数值小的一个，并且移动数值小的指针
                int height = heights[left] <= heights[right] ? heights[left++] : heights[right--];
                //计算本次循环中的容积
                int curArea = width * height;
                area = Math.max(curArea, area);
            }
            return area;
        }
        /**
         * 1 8 6 2 5 4 8 3 7
         * 0 1 2 3 4 5 6 7 8
         * 0 1
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}