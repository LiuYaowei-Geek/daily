//You are given an integer array nums. You are initially positioned at the array
//'s first index, and each element in the array represents your maximum jump lengt
//h at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 10794 👎 616


package com.lyw.leetCode.editor.en.greedy;

//Java：T_55_Jump Game
public class T_55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new T_55_JumpGame().new Solution();
        // TO TEST
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心 时间复杂度O(n), 空间复杂度O(1)
        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                //永远走不到i位子
                if (i > maxReach) {
                    return false;
                }
                maxReach = Math.max(maxReach, nums[i] + i);
            }
            return true;
        }

        //dp 时间复杂度O(n^2), 空间复杂度O(n)
        public boolean canJump2(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[n - 1] = true;

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= nums[i] && i + j < n; j++)
                    if (dp[i + j]) {
                        dp[i] = true;
                        //推出当前层的循环
                        break;
                    }
            }
            return dp[0];
        }
    }
    /**
     * 0 1 2 3 4
     * 2 3 1 1 4
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}