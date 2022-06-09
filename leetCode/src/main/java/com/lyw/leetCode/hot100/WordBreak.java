package com.lyw.leetCode.hot100;
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
// 👍 9891 👎 439

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * questionId：139
  * question：Word Break
  * date：2022-03-21 18:15:43
*/
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        System.out.println(solution.wordBreak("cars", new ArrayList<>(Arrays.asList("car","ca","rs"))));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i+1);
                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
