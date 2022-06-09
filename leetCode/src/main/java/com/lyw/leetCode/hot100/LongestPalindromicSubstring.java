package com.lyw.leetCode.hot100;
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
// 👍 15004 👎 884

/**
  * questionId：5
  * question：Longest Palindromic Substring
  * date：2022-01-03 13:24:50
*/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //max记录目标结果
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            // odd length 奇数长度  example:babab
            String s1 = extend(s, i, i);
            // even length 偶数长度 example:cbbd
            String s2 = extend(s, i, i + 1);
            //s1每次循环都会变
            if (s1.length() > max.length()) max = s1;
            //s2每次循环都会变
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

        /**
         * 奇数时：判断当前位子前一个数和后一个数是否相等
         * 偶数时：先判断当前位子的数是否和后一个数相等，再判断当前位子前一个数和后后一个数是否相等
         * try to extend Palindrome as possible
         * @param s origin string 原始字符串
         * @param i target string left index 目标字符串的左索引
         * @param j target string right index 目标字符串的右索引
         * @return extend result 扩展后的回文字符串
         */
    private String extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            //unmatched Palindrome 不是回文数的判断条件
            if (s.charAt(i) != s.charAt(j)) break;
        }
        //last loop i and j. i+1 = (i-- +1); j: substring is close left and open right
        //之前做过i-- 和j++。所以返回时需要进++i, j不用操作，因为substring是左闭右开的，使用j++会数组越界
        return s.substring(i + 1, j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
