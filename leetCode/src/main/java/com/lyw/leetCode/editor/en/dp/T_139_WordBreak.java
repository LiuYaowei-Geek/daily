//Given a string s and a dictionary of strings wordDict, return true if s can be
// segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Hash Table String Dynamic Programming Trie Memoization 
// 👍 10308 👎 453


package com.lyw.leetCode.editor.en.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：T_139_Word Break
public class T_139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new T_139_WordBreak().new Solution();
        // TO TEST
        String s = "aaaaaaa";
        List<String> list = Arrays.asList("aaaa", "aaa");
        System.out.println(solution.wordBreak(s, list));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp，时间复杂度O(n^2) 空间复杂度O(n)
         * 双层循环，单层循环不具备回溯能力，只能按顺序检索一次。将字符串分成0到j-1和j到i-1两部分
         * 状态转移方程：dp[i] = dp[j] && set.contains(s.substring(j, i))
         */
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() < 1) {
                return true;
            }
            //dp[i]表示0到i-1位置是否可以被字典里的单词组成
            boolean[] dp = new boolean[s.length() + 1];
            //空字符串可以组成，初始化为0
            dp[0] = true;
            //利用hash检索单词，时间复杂度O(1) 空间复杂度O(n)
            Set<String> set = new HashSet<>(wordDict);

            //双层循环，单层循环不具备回溯能力，只能按顺序检索一次。将字符串分成0到j-1和j到i-1两部分
            //状态转移方程：dp[i] = dp[j] && set.contains(s.substring(j, i))
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String cur = s.substring(j, i);
                    dp[i] = dp[j] && set.contains(cur);
                    if (dp[i]) {
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}