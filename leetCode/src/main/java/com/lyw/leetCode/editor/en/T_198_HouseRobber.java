//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken into
// on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Array Dynamic Programming 
// 👍 12019 👎 259


package com.lyw.leetCode.editor.en;

//Java：T_198_House Robber
public class T_198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new T_198_HouseRobber().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(solution.rob(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp，时间复杂度O(n)， 空间复杂度O(n)
        public int rob(int[] nums) {
            //base case
            if (nums == null || nums.length < 1) {
                return 0;
            }
            //dp[i]代表当前房间可以偷到的最大金额
            //dp[i]位置对于nums[i-1]位置
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i <= nums.length; i++) {
                //状态转移方程
                //当前房间可以偷到的最大金额取dp[i - 1]和dp[i - 2] + nums[i-1]的最大值
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }
            return dp[nums.length];
        }

        public int rob2(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }

        //dp滚动数组，时间复杂度O(n), 空间复杂度O(1)
        //最后结果只和当前房屋前两间房屋最高金额相关
        public int rob3(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            //first记录前前间房的最大金额，初始化为nums[0]
            int first = nums[0];
            //second记录前一间房的最大金额，初始化为nums[0]和nums[1]的最大值
            int second = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                //临时变量，暂存second
                int temp = second;
                //second记录当前房间的最大金额
                second = Math.max(first + nums[i], second);
                //first滚动，记录原始second值，first和second滚动
                first = temp;
            }
            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}