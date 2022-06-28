//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2), because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 5371 👎 91


package com.lyw.leetCode.editor.en.dp;

//Java：T_213_House Robber II
public class T_213_HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new T_213_HouseRobberIi().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 3, 2, 1, 4};
        int[] nums2 = new int[]{1,2,3,1};
//        System.out.println(solution.rob(nums));
        System.out.println(solution.rob2(nums2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度O(n), 空间复杂度O(1)
         * 1. 拆分成两段
         * 2. 不偷最后一间房，范围是[0, n-2]
         * 3. ，范围是[1, n-1]
         * 4. 两部分组合可以完全覆盖整个数组，结果即是两部分结果取最大值
         */
        public int rob(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            //拆分成两段
            //不偷最后一间房，范围是[0, n-2]
            //不偷第一间房，范围是[1, n-1]
            //两部分组合可以完全覆盖整个数组，结果即是两部分结果取最大值
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }

        public int rob(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <=end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }

        public int rob2(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robSub(nums, 0, nums.length-2), robSub(nums, 1, nums.length-1));
        }

        private int robSub(int[] nums, int start, int end) {
            int[] dp = new int[end - start + 1];
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start], nums[start+1]);
            for (int i = 2; i < end-start+1; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start+i]);
            }
            return dp[end - start];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}