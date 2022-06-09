package com.lyw.leetCode.hot100;
//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken into
// on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Array Dynamic Programming 
// 👍 11584 👎 249

/**
  * questionId：198
  * question：House Robber
  * date：2022-03-24 16:38:32
*/
public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int rob = 0; //max money can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<nums.length; i++) {
            int currob = notrob + nums[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //Initialize an arrays to store the money
        int[] mark = new int[nums.length];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);

        //Using Dynamic Programming to mark the max money in loop.
        for (int i = 2; i < nums.length; i++) {
            //nums[i] + mark[i - 2]: 偷nums[i]的最大值
            //mark[i - 1]: 不偷nums[i]的最大值
            //mark[i]: 偷或者不偷i位子的最大值
            mark[i] = Math.max(nums[i] + mark[i - 2], mark[i - 1]);
        }
        return mark[nums.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
