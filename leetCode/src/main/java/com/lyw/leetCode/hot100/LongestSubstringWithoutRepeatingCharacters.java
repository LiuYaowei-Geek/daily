package com.lyw.leetCode.hot100;
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
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
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
// 👍 19014 👎 867

import java.util.HashMap;
import java.util.Map;

/**
  * questionId：3
  * question：Longest Substring Without Repeating Characters
  * date：2021-11-22 19:56:08
*/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("abcdeafbdgcbb"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //dvdf
        //0 p0 w1
        //2 w0 k1 e2
        //3 w0
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int temp = 0;
                if (map.containsKey(s.charAt(j))) {
                    temp = j;
                    max = Math.max(max, map.size());
                    map.clear();
                }
                map.put(s.charAt(j), j - temp);
            }
            max = Math.max(max, map.size());
            map.clear();
        }
        return Math.max(max, map.size());
    }
    //abba
    public int lengthOfLongestSubstring2(String s) {
        //the slide window size is the result
        int res = 0;
        //use hashmap define the slide window
        Map<Character, Integer> map = new HashMap<>();
        //init left point and right pint
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                //move left point, code:map.get(s.charAt(right)) is current left point position
                //when right point occurred same value, move left point to the same value's next position
                //滑动窗口，当右节点遇到相同值时，将左节点移到第一个这个值的下一个位子，例子：abcdeafbdgcbb
                left = Math.max(map.get(s.charAt(right)), left);
                //cannot direct use map.get(s.charAt(right)). example: abba
                //left = map.get(s.charAt(right));
            }
            //make res keep biggest
            res = Math.max(res, right - left + 1);
            //put element into slide map
            map.put(s.charAt(right), right + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
