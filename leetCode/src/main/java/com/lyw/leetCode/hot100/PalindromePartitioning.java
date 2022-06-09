package com.lyw.leetCode.hot100;
//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 6198 👎 190

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：131
  * question：Palindrome Partitioning
  * date：2022-03-06 18:41:02
*/
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab").forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }
    private void backtrack(List<List<String>> res, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                //substring左闭右开
                tempList.add(s.substring(start, i + 1));
                backtrack(res, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * 判断是否是回文
     * @param s
     * @param low 起始位子
     * @param high 最终位子
     * @return
     */
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
