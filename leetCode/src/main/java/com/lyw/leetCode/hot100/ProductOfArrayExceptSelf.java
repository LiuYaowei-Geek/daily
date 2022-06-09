package com.lyw.leetCode.hot100;
//Given an integer array nums, return an array answer such that answer[i] is equ
//al to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the divi
//sion operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 105 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The out
//put array does not count as extra space for space complexity analysis.) 
// Related Topics Array Prefix Sum 
// 👍 11607 👎 707

/**
  * questionId：238
  * question：Product of Array Except Self
  * date：2022-03-29 23:21:05
*/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
         * 例子：1 2 3 4 => 24 12 8 6
         * nums[0]=nums[1]*nums[2]*nums[3]
         * nums[1]=nums[0]*nums[2]*nums[3]
         * nums[2]=nums[0]*nums[1]*nums[3]
         * nums[3]=nums[0]*nums[1]*nums[2]
         */
        int[] res = new int[nums.length];
        /**
         * 正序遍历
         * temp                          res
         * 1                             res[0]
         * 1*nums[0]                     res[1]
         * 1*nums[0]*nums[1]             res[2]
         * 1*nums[0]*nums[1]*nums[2]     res[3]
         */
        for (int i = 0, temp = 1; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        /**
         * 倒序遍历
         * temp                          res
         * 1                             res[3]=1*nums[0]*nums[1]*nums[2]
         * 1*nums[3]                     res[2]=1*nums[0]*nums[1]*1*nums[3]
         * 1*nums[2]*nums[3]             res[1]=1*nums[2]*nums[3]*1*nums[0]
         * 1*nums[1]*nums[2]*nums[3]     res[0]=1*nums[1]*nums[2]*nums[3]*1
         */
        for (int i = nums.length - 1, temp = 1; i >= 0 ; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
