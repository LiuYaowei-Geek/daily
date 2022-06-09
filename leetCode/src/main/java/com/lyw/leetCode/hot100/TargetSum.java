package com.lyw.leetCode.hot100;
//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics Array Dynamic Programming Backtracking 
// 👍 6593 👎 250

/**
  * questionId：494
  * question：Target Sum
  * date：2022-04-12 22:04:53
*/
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        //System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(2 << 1);
        System.out.println(5>>1);
        System.out.println((-10)>>>1);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //>>>是无符号右移，右移移位等于除以2，左移一位等于乘以2
        return sum < target || (target + sum) % 2 > 0 || target + sum < 0 ? 0 : subsetSum(nums, (target + sum) >>> 1);
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            //top-bottom
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
