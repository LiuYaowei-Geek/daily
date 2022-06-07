//You are given a string s and an integer k. You can choose any character of the
// string and change it to any other uppercase English character. You can perform
//this operation at most k times.
//
// Return the length of the longest substring containing the same letter you can
// get after performing the above operations.
//
//
// Example 1:
//
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
//
//
// Example 2:
//
//
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length
//
// Related Topics Hash Table String Sliding Window
// 👍 4315 👎 173


package com.lyw.leetCode.editor.en;

//Java：T_424_Longest Repeating Character Replacement
public class T_424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new T_424_LongestRepeatingCharacterReplacement().new Solution();
        // TO TEST
        String s = "AABABBA";
        int k = 1;
        System.out.println(solution.characterReplacement(s, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口，时间复杂度O(n), 空间复杂度O(m),s 为字符串长度，m为字符集大小
         * @param s
         * @param k
         * @return
         */
        public int characterReplacement(String s, int k) {
            int len = s.length();
            //存储s字符串中每个字符出现的次数
            int[] count = new int[26];
            //start左指针
            //maxCount出现字符最多的次数
            //maxLength区间长度
            int start = 0, maxCount = 0, maxLength = 0;
            //移动右指针
            for (int end = 0; end < len; end++) {
                //end位置字符出现次数加一，与maxCount取最大值，保证maxCount为出现次数最多字符的出现次数
                maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
                //与出现次数最多字符不一致的字符数量大于k
                while (end - start + 1 - maxCount > k) {
                    //start位置字符出现次数减一
                    count[s.charAt(start) - 'A']--;
                    //左指针左移
                    start++;
                }
                //计算区间最大长度
                maxLength = Math.max(maxLength, end - start + 1);
            }
            return maxLength;
        }
    }
//leetce submit region end(Prohibit modification and deletion)

}