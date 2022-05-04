//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order o
//f the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both s
//trings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
// Related Topics String Dynamic Programming 
// 👍 6324 👎 70


package com.lyw.leetCode.editor.en;

//Java：T_1143_Longest Common Subsequence
public class T_1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new T_1143_LongestCommonSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二维动态规划，时间复杂度O(xy)，空间复杂度O(xy)， xy对应两个字符串的长度
        public int longestCommonSubsequence(String text1, String text2) {
            //base case
            if (text1 == null || text2 == null) {
                return 0;
            }

            int x = text1.length();
            int y = text2.length();
            //dp[i][j]表示text1[0:i]和text2[0:j]最长公共子序列的长度。i和j表示text1和text2的长度
            //当i或j为0时，text1或text2为空，所以dp[i][0]=dp[0][j]=0
            //dp数组中的ij，对于字符串中i-1和j-1位置，因为dp[0][0]是空
            int[][] dp = new int[x + 1][y + 1];
            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= y; j++) {
                    //状态转移方程，区分i-1位置和j-1位置是否相等两种情况
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}