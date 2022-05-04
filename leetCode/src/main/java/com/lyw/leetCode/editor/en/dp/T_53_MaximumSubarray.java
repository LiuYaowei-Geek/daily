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
// 👍 20224 👎 991


package com.lyw.leetCode.editor.en.dp;
//Java：T_53_Maximum Subarray
public class T_53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new T_53_MaximumSubarray().new Solution();
        // TO TEST
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray1(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划，时间复杂度O(n)， 空间复杂度O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = Integer.MIN_VALUE;
        for (int cur : nums) {
            //当cur为负数时，会数组越界，结果计算错误
            maxEndingHere = Math.max(maxEndingHere + cur, cur);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}