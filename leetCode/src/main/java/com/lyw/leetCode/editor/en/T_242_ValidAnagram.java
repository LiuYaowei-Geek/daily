//Given two strings s and t, return true if t is an anagram of s, and false othe
//rwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you adapt
// your solution to such a case? 
// Related Topics Hash Table String Sorting 
// 👍 4848 👎 212


package com.lyw.leetCode.editor.en;
//Java：T_242_Valid Anagram
public class T_242_ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new T_242_ValidAnagram().new Solution();
        // TO TEST
        String s = "anagram", t = "nagaram";
        String s1 = "rat", t1 = "car";
        System.out.println(solution.isAnagram(s, t));
        System.out.println(solution.isAnagram(s1, t1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] array = new int[128];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i)]--;
        }
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}