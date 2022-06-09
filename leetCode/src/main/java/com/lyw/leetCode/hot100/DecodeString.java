package com.lyw.leetCode.hot100;
//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; there are no extra whit
//e spaces, square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any digit
//s and that digits are only for those repeat numbers, k. For example, there will 
//not be input like 3a or 2[4]. 
//
// 
// Example 1: 
//
// 
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// 
//
// Example 2: 
//
// 
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
// 
//
// Example 3: 
//
// 
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
// Related Topics String Stack Recursion 
// 👍 7900 👎 336

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
  * questionId：394
  * question：Decode String
  * date：2022-04-10 22:39:19
*/
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String decodeStringWithRecursion(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return helper(queue);
    }

    private String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
