//Given two integers a and b, return the sum of the two integers without using t
//he operators + and -. 
//
// 
// Example 1: 
// Input: a = 1, b = 2
//Output: 3
// Example 2: 
// Input: a = 2, b = 3
//Output: 5
// 
// 
// Constraints: 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics Math Bit Manipulation 
// 👍 2508 👎 3754


package com.lyw.leetCode.editor.en;
//Java：T_371_Sum of Two Integers
public class T_371_SumOfTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new T_371_SumOfTwoIntegers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}