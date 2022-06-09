package com.lyw.leetCode.hot100;
//Given an integer n, return an array ans of length n + 1 such that for each i (
//0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 105 
// 
//
// 
// Follow up: 
//
// 
// It is very easy to come up with a solution with a runtime of O(n log n). Can 
//you do it in linear time O(n) and possibly in a single pass? 
// Can you do it without using any built-in function (i.e., like __builtin_popco
//unt in C++)? 
// 
// Related Topics Dynamic Programming Bit Manipulation 
// 👍 6744 👎 317

/**
  * questionId：338
  * question：Counting Bits
  * date：2022-04-10 15:26:49
*/
public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * https://leetcode.com/problems/counting-bits/discuss/79539/Three-Line-Java-Solution
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        for (int i=1; i<=n; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
    /**
     * https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
     */
     public int[] countBitsWithDP(int n) {
         int result[] = new int[n + 1];
         int offset = 1;
         for (int index = 1; index < n + 1; ++index){
             if (offset * 2 == index){
                 offset *= 2;
             }
             result[index] = result[index - offset] + 1;
         }
         return result;
     }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
