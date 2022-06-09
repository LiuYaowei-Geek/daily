package com.lyw.leetCode.hot100;
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 11758 👎 463

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：22
  * question：Generate Parentheses
  * date：2022-02-23 22:55:52
*/
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

        /**
         * (
         * ((
         * (((
         * ((()
         * ((())
         * ((()))
         * (()
         * (()(
         * (()()
         * (()())
         * (())
         * (())(
         * (())()
         * ()
         * ()(
         * ()((
         * ()(()
         * ()(())
         * ()()
         * ()()(
         * ()()()
         * @param list
         * @param str
         * @param open
         * @param close
         * @param max
         */
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open+1, close, max);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close+1, max);
        }
    }
        /**
         *
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
