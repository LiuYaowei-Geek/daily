package com.lyw.leetCode.hot100;
//You are given an integer array nums. You are initially positioned at the array
//'s first index, and each element in the array represents your maximum jump lengt
//h at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 10138 👎 587

/**
  * questionId：55
  * question：Jump Game
  * date：2022-03-10 07:30:39
*/
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solution.canJump(new int[] {3,2,1,0,4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            //循环完后，当前索引i比最大能到的索引位子还大，表示jump不动了，无法到达终点
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        //nums.length = 1时，返回true
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
