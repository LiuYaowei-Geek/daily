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
// 👍 12023 👎 735


package com.lyw.leetCode.editor.en.array;
//Java：T_238_Product of Array Except Self
public class T_238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new T_238_ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            res[i] = 1;
            while (temp < nums.length) {
                if (temp != i) {
                    res[i] *= nums[temp];
                }
                temp++;
            }
        }
        return res;
    }

    //时间复杂度O(n)  空间复杂度O(1)
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        //先计算i位置左边数字的乘积
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //right代表当前位置右边数字的乘积
        int right = 1;
        //每个位置的结果等于当前位置左边数字的乘积乘以右边数字的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}