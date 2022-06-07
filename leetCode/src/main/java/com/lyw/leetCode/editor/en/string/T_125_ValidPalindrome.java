//A phrase is a palindrome if, after converting all uppercase letters into lower
//case letters and removing all non-alphanumeric characters, it reads the same for
//ward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric character
//s.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 105 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 
// 👍 3653 👎 5187


package com.lyw.leetCode.editor.en.string;

//Java：T_125_Valid Palindrome
public class T_125_ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new T_125_ValidPalindrome().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针
        public boolean isPalindrome(String s) {
            char[] cArray = s.toCharArray();
            for (int start = 0, end = s.length() - 1; start < end; ) {
                if (!Character.isLetterOrDigit(cArray[start])) {
                    start++;
                } else if (!Character.isLetterOrDigit(cArray[end])) {
                    end--;
                } else if (Character.toLowerCase(cArray[start++]) != Character.toLowerCase(cArray[end--])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}