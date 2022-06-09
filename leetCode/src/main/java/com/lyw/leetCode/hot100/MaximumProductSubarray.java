package com.lyw.leetCode.hot100;
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
// 👍 10850 👎 338

/**
  * questionId：152
  * question：Maximum Product Subarray
  * date：2022-03-23 10:18:36
*/
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        System.out.println(solution.maxProduct(new int[] {-2,0,-1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //max为乘积过程中的最大值，min为乘积过程中的最小值，因为负负得正，所以需要记录最小值。res为返回结果
        int max = nums[0], min = nums[0], res = nums[0];
        //i从1位子开始遍历
        for (int i = 1; i < nums.length; i++) {
            //temp记录max当前值
            int temp = max;
            //计算max，取max和min与nums[i]的乘积最大值与nums[i]做比较，取最大值。乘积为负时，nums[i]最大
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            //计算max，取temp(temp记录了之前的max值)和min与nums[i]的乘积最大值与nums[i]做比较，取最小值。
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            //res取值
            res = Math.max(max, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
