//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and b
//lue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant ex
//tra space? 
// Related Topics Array Two Pointers Sorting 
// 👍 9585 👎 411


package com.lyw.leetCode.editor.en.array;

import java.util.Arrays;

//Java：T_75_Sort Colors
public class T_75_SortColors {
    public static void main(String[] args) {
        Solution solution = new T_75_SortColors().new Solution();
        // TO TEST
        int[] nums = new int[]{1,2,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //双指针
        ///时间复杂度：O(N) 空间复杂度：O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //执行需要和0进行替换的位置
        int low = 0;
        //执行需要和2进行替换的位置
        int high = nums.length - 1;

        for (int i = 0; i <= high; i++) {
            //两个if判断，不能用if-else
            if (nums[i] == 0) {
                swap(nums, i, low++);
            }
            //判断完2后需要i--,对i位置重新判断
            if (nums[i] == 2) {
                swap(nums, i--, high--);
            }
        }
    }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}