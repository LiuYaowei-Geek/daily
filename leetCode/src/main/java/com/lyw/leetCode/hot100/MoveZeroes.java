package com.lyw.leetCode.hot100;
//Given an integer array nums, move all 0's to the end of it while maintaining t
//he relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related Top
//ics Array Two Pointers 
// 👍 8760 👎 236

import java.util.Arrays;

/**
  * questionId：283
  * question：Move Zeroes
  * date：2022-04-09 17:07:10
*/
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[] {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
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
