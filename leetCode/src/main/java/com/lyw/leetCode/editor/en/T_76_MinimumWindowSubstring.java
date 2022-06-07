//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics Hash Table String Sliding Window 
// 👍 10236 👎 535


package com.lyw.leetCode.editor.en;

//Java：T_76_Minimum Window Substring
public class T_76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new T_76_MinimumWindowSubstring().new Solution();
        // TO TEST
        //正常情况
        String s = "ADOBECODEBANC", t = "ABC";
        //不合符要求情况
        String s2 = "a", t2 = "b";
        //重复字符情况
        String s3 = "acbbaca", t3 = "aba";
        System.out.println(solution.minWindow(s, t));
        System.out.println(solution.minWindow(s2, t2));
        System.out.println(solution.minWindow(s3, t3));
        //a-z:97-122
        //A-Z:65-90
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口，时间复杂度O(s+t), 空间复杂度O(s+t)
        public String minWindow(String s, String t) {
            //a-z:97-122
            //A-Z:65-90
            //128可以覆盖A-z所有字符
            int[] map = new int[128];
            for (char c : t.toCharArray()) {
                //标记t中的字符，因为字符可以重复，所以用位置和次数进行标记
                map[c]++;
            }
            //start和end滑动窗口左右边界
            //minStart最小区间开始位置，minLen最小区间长度
            //counter计数器，表示当前窗口是否包含t
            int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
            while (end < s.length()) {
                final char endChar = s.charAt(end);
                //end位置字符在t中存在，counter减一
                if (map[endChar] > 0) counter--;
                //在t中存在且处理过的字符减一，在t中不存在的字符减一
                map[endChar]--;
                //扩大窗口
                end++;
                //start到end窗口包含t所有的字符
                while (counter == 0) {
                    //记录最小长度
                    if (minLen > end - start) {
                        minLen = end - start;
                        //跟新最小区间左边界位置
                        minStart = start;
                    }
                    final char startChar = s.charAt(start);
                    //移除左边界时，需要还原标识，之前是--所以这里要++
                    map[startChar]++;
                    //start位置字符在t中存在，移除后，计数器加1，破掉循环，并且表示还差一个字符使窗口满足包含t的条件
                    if (map[startChar] > 0) counter++;
                    //缩小窗口
                    start++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}