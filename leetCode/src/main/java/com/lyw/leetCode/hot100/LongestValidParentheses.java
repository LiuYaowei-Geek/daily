package com.lyw.leetCode.hot100;
//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
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
// 0 <= s.length <= 3 * 104 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming Stack 
// 👍 7519 👎 256

import java.util.LinkedList;

/**
  * questionId：32
  * question：Longest Valid Parentheses
  * date：2022-04-15 11:51:34
*/
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14167/Simple-JAVA-solution-O(n)-time-one-stack
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14278/Two-Java-solutions-with-explanation.-Stack-and-DP.-Short-and-easy-to-understand.
    public int longestValidParenthesesWithDP(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
