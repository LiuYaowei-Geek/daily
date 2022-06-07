//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 12984 👎 582


package com.lyw.leetCode.editor.en;

import java.util.Stack;

//Java：T_20_Valid Parentheses
public class T_20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new T_20_ValidParentheses().new Solution();
        // TO TEST
        String s = "((";
        String s2 = "()[]{}";
        String s3 = "){";
        System.out.println(solution.isValid(s));
        System.out.println(solution.isValid(s2));
        System.out.println(solution.isValid(s3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    //栈为空直接返回false
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char temp = stack.pop();
                    if (c == ')' && (temp == '[' || temp == '{')) {
                        return false;
                    } else if (c == '}' && (temp == '[' || temp == '(')) {
                        return false;
                    } else if (c == ']' && (temp == '{' || temp == '(')) {
                        return false;
                    }
                }
            }
            //栈不为空返回错误
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}