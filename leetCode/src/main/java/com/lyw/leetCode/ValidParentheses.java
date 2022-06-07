package com.lyw.leetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 使用栈判断输入的字符串是否对称
 */
public class ValidParentheses {
    private static HashMap<Character, Character> mappings;

    static {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        boolean flag = isValid(s);
    }
}
