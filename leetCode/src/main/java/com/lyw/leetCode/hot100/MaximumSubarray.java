package com.lyw.leetCode.hot100;
//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 18970 👎 904

/**
  * questionId：53
  * question：Maximum Subarray
  * date：2022-03-09 22:41:57
*/
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(solution.maxSubArray(new int[] {1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int item: nums) {
            sum += item;
            max = Math.max(sum, max);
            //sum为负数时，设置sum为0，等于舍弃了前面为负数的和，保证后面的和更大
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
