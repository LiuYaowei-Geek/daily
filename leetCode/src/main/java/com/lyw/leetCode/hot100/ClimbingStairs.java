package com.lyw.leetCode.hot100;
//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 
// 👍 10801 👎 330

/**
  * questionId：70
  * question：Climbing Stairs
  * date：2022-03-13 16:34:46
*/
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(6));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 列子： n = 6
     * 梯子号：1 2 3 4 5 6
     * 组合数：1 2 3 4 8 13
     *
     * 以第5阶梯为例，第5阶梯的组合数等于第4阶梯组合数加上第3阶梯组合数。
     * 理解：第5阶梯的组合数等于留一步走到5的组合数加上留两步走到5的组合数，即第4阶梯组合数加上第3阶梯组合数
     *
     * @param n 梯子长度
     * @return 每次走一步或者两步，走法的组合数
     */
    public int climbStairs(int n) {
        //特殊数处理
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
