//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity? 
// Related Topics Array Binary Search Dynamic Programming 
// 👍 11623 👎 232


package com.lyw.leetCode.editor.en;

//Java：T_300_Longest Increasing Subsequence
public class T_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new T_300_LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划，时间复杂度O(n^2), 空间复杂度O(n)
        //两次循环，找当前位置最长上升子序列长度，dp[i] = Math.max(dp[i], dp[j] + 1)
        public int lengthOfLIS(int[] nums) {
            //base case
            if (nums == null || nums.length < 1) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            //dp[i]表示i位置包含i，最长上升子序列长度。所以dp长度和nums长度相等
            int[] dp = new int[nums.length];
            //初始0位置
            dp[0] = 1;
            //初始话返回值
            int res = 1;
            //从1位置开始遍历nums
            for (int i = 1; i < nums.length; i++) {
                //dp[i]位置初始值为1
                dp[i] = 1;
                //遍历j到i位置
                for (int j = 0; j < i; j++) {
                    //i位置前有几个比i位置小的数，即累加上升子序列长度
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        //贪心加二分
        public int lengthOfLIS2(int[] nums) {
            //base case
            if (nums == null || nums.length < 1) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            int[] tails = new int[nums.length];
            int res = 0;
            for (int cur : nums) {
                int i = 0, j = res;
                while (i != j) {
                    int mid = i + (i - j) / 2;
                    if (tails[mid] < cur) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                tails[i] = cur;
                if (i == res) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}