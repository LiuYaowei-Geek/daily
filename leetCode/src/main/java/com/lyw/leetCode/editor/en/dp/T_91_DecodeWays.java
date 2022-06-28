//A message containing letters from A-Z can be encoded into numbers using the fo
//llowing mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped back
// into letters using the reverse of the mapping above (there may be multiple ways
//). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped int
//o 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics String Dynamic Programming 
// 👍 6761 👎 3808


package com.lyw.leetCode.editor.en.dp;

//Java：T_91_Decode Ways
public class T_91_DecodeWays {
    public static void main(String[] args) {
        Solution solution = new T_91_DecodeWays().new Solution();
        // TO TEST
        System.out.println(solution.numDecodings("101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度O(n), 空间复杂度O(n)，空间复杂度可以通过间数组换成有限的变量降为O(1)
         */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for (int i = 2; i <= n; i++) {
                //当前字符属于[0,9]，dp[i] = dp[i-1]
                int first = Integer.parseInt(s.substring(i - 1, i));
                if (first >= 1 && first <= 9) {
                    //由于dp[i]初始值为0，可以写成dp[i] = dp[i - 1]
                    dp[i] += dp[i - 1];
                }
                //当前字符和前一个字符组成的数字属于[10,26]
                int second = Integer.valueOf(s.substring(i - 2, i));
                if (second >= 10 && second <= 26) {
                    //dp[i] = dp[i-2]或者dp[i] = dp[i-1]+dp[i-2]
                    //例如123->{(1,2,3), (12,3), (1,23)}
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }

        /**
         * 时间复杂度O(n), 空间复杂度O(n)，空间复杂度可以通过间数组换成有限的变量降为O(1)
         * 1. 初始化dp整型数组，值全为0
         * 2. 从索引1位置开始遍历，如果当前数值在[1,9]区间内，dp[i] = dp[i-1]；当前数值是0时，dp[i]保持为0
         * 3. 如果当前数值加上前一位数值在[10,26]区间内，的dp[i]=dp[i]+dp[i-2]，索引小于2时，dp[i]=dp[i]+1；
         */
        public int numDecodings2(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n];
            dp[0] = s.charAt(0) != '0' ? 1 : 0;
            for (int i = 1; i < n; i++) {
                //使用Integer.parseInt可以避免拆箱
                int first = Integer.parseInt(s.substring(i, i + 1));
                if (first >= 1 && first <= 9) {
                    dp[i] = dp[i - 1];
                }
                int second = Integer.valueOf(s.substring(i - 1, i + 1));
                if (second >= 10 && second <= 26) {
                    dp[i] = i >= 2 ? dp[i] + dp[i - 2] : dp[i] + 1;
                }
            }
            return dp[n - 1];
        }
    }
    /**
     * 123
     * 0-1
     * 1-1
     * 2-2
     * 3-3
     *
     */
//leetcode submit region end(Prohibit modification and deletion)

}