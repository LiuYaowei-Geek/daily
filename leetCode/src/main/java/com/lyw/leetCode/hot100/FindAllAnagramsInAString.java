package com.lyw.leetCode.hot100;
//Given two strings s and p, return an array of all the start indices of p's ana
//grams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s and p consist of lowercase English letters. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 7257 👎 251

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * questionId：438
  * question：Find All Anagrams in a String
  * date：2022-04-11 21:40:57
*/
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() && s.length() - i >= p.length(); i++) {
            if (p.contains(s.substring(i, i+1))) {
                String ss = s.substring(i, i + pLength);
                char[] sc = ss.toCharArray();
                Arrays.sort(sc);
                if (String.valueOf(sc).equals(String.valueOf(pc))) {
                    res.add(i);
                }

            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsWithSlidingWindow(String s, String p) {
        int left = 0;
        int right = 0;
        int matchSize = p.length();
        int[] map = new int[256];
        List<Integer> res = new ArrayList<>();
        // count the char number in p 计算p中各个字符的数量
        for (char c : p.toCharArray()) {
            map[c]++;
        }

        // build window 开始进行sliding window
        while (right < s.length()) {
            // this char exists in p
            // 如果当前的char是存在于p中，则目标大小matchsize就得减少
            // 判断标准就是他的值不是为-1
            if (map[s.charAt(right)] > 0) { matchSize--; }
            map[s.charAt(right)]--;

            // if the window size equals to p
            // 如果此时左右指针的差值等于p的长度
            if (right - left == p.length() - 1) {
                // check matchSize equals to 0
                // 如果此时目标大小也是0，说明这就是需要的一个子串
                if (matchSize == 0)
                // add the left index
                { res.add(left); }

                // move left pointer to start new search
                // 如果当这个字符原来是p中的话，现在移动指针需要还原以前原有的matchSize，开始新的搜索
                if (map[s.charAt(left)] >= 0) { matchSize++; }
                // 还原以前每个元素减去的1
                map[s.charAt(left)]++;
                left++;
            }
            // move right
            right++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
