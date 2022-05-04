//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 23327 👎 1051


package com.lyw.leetCode.editor.en;

import java.util.HashMap;
import java.util.Map;

//Java：T_3_Longest Substring Without Repeating Characters
public class T_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new T_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        String s1 = "pwwkew";
        String s2 = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口，时间复杂度O(n), 空间复杂度O(n)
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() < 1) {
                return 0;
            }
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();

            //滑动窗口
            for (int start = 0, end = 0; end < s.length(); end++) {
                //end位置在窗口中不存在，start保持不变
                //end位置在窗口中存在，位子记为cur，start取start和cur+1的最大值
                //取最大值是保证start始终保持向右移移动，不会向左移动。因为向左移动会使窗口中存在其他重复字符
                start = Math.max(start, map.getOrDefault(s.charAt(end), -1) + 1);
                map.put(s.charAt(end), end);
                max = Math.max(max, end - start + 1);
            }
            return max;
        }
    }
    /**
     * abcabcbb
     * 11122234
     *
     * pwwkew
     * 112113
     */
//leetcode submit region end(Prohibit modification and deletion)

}