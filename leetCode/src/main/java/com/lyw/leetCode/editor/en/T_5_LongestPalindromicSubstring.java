//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 17548 👎 1045


package com.lyw.leetCode.editor.en;

//Java：T_5_Longest Palindromic Substring
public class T_5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new T_5_LongestPalindromicSubstring().new Solution();
        // TO TEST
        String s = "cbbd";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 中心扩展法，时间复杂度O(n^2)，空间复杂度O(1)
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            String max = "";
            for (int i = 0; i < s.length(); i++) {
                //回文字符串为奇数时
                String s1 = extend(s, i, i);
                //回文字符串为偶数时
                String s2 = extend(s, i, i + 1);
                if (s1.length() > max.length()) {
                    max = s1;
                }
                if (s2.length() > max.length()) {
                    max = s2;
                }
            }
            return max;
        }

        private String extend(String s, int i, int j) {
            //中心扩展，左边界左移，右边界右移
            for (; i >= 0 && j < s.length(); i--, j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
            }
            //返回扩展后的字符串，左闭右开，之前为i--和j++，所以还原操作为++i，右边界为开，所以j不用--
            //不满足回文时，返回空字符串
            return s.substring(++i, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}