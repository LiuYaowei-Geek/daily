package com.lyw.leetCode.hot100;
//Given an array of integers temperatures represents the daily temperatures, ret
//urn an array answer such that answer[i] is the number of days you have to wait a
//fter the ith day to get a warmer temperature. If there is no future day for whic
//h this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics Array Stack Monotonic Stack 
// 👍 6745 👎 155

import java.util.Stack;

/**
  * questionId：739
  * question：Daily Temperatures
  * date：2022-04-13 23:04:20
*/
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
