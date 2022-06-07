//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 6261 👎 155


package com.lyw.leetCode.editor.en;

//Java：T_647_Palindromic Substrings
public class T_647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new T_647_PalindromicSubstrings().new Solution();
        // TO TEST
        String s = "abc";
        String s1 = "aaa";
        System.out.println(solution.countSubstrings(s));
        System.out.println(solution.countSubstrings(s1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int count1 = extend(s, i, i);
                int count2 = extend(s, i, i + 1);
                count = count + count1 + count2;
            }
            return count;
        }

        private int extend(String s, int i, int j) {
            int count = 0;
            for (; i >= 0 && j < s.length(); i--, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}