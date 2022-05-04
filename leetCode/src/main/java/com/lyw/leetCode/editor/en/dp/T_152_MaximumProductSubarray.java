//Given an integer array nums, find a contiguous non-empty subarray within the a
//rray that has the largest product, and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
// Related Topics Array Dynamic Programming 
// 👍 11263 👎 348


package com.lyw.leetCode.editor.en.dp;

//Java：T_152_Maximum Product Subarray
public class T_152_MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new T_152_MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划，时间复杂度O(n)，空间复杂度O(1)
        //区别与数组最大区间和，乘积时需要同时记录最大值和最小值，因为负负得正
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int res = nums[0];
            int max = nums[0];
            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //临时变量记录当前max值，避免后续使用max计算时，max值变化了
                int tempMax = max;
                //max * nums[i]、min * nums[i]和nums[i]三者取最大值
                max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                //tempMax * nums[i]、min * nums[i]和nums[i]三者取最小值
                min = Math.min(Math.min(tempMax * nums[i], min * nums[i]), nums[i]);
                //max和res取最大值
                res = Math.max(max, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}