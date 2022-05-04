//Given an array of distinct integers nums and a target integer target, return t
//he number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow n
//egative numbers? 
// Related Topics Array Dynamic Programming 
// 👍 3365 👎 388


package com.lyw.leetCode.editor.en.dp;

//Java：T_377_Combination Sum IV
public class T_377_CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new T_377_CombinationSumIv().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp，时间复杂度O(mn)，空间复杂度O(m),m为target长度，n为nums大小
        //状态转移方程：dp[i] += dp[i - num]。因为i = (i-num) + num，所以dp[i]等于所有dp[i - num]的和
        public int combinationSum4(int[] nums, int target) {
            //dp[i]表示从数组中选取元素和为i的组合数
            int[] dp = new int[target + 1];
            //和为0时，从数据中都不选，所以组合数为1
            dp[0] = 1;
            //从1遍历到target
            for (int i = 1; i <= target; i++) {
                //遍历数组元素
                for (int num : nums) {
                    //num全为正数，所以当num小于等于i时才能组合为i
                    if (num <= i) {
                        //因为i = (i-num) + num，所以dp[i]等于所有dp[i - num]的和
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}