package com.lyw.leetCode.hot100;
//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three di
//fferent ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
// Related Topics Array Math Two Pointers 
// 👍 8832 👎 1250

/**
  * questionId：189
  * question：Rotate Array
  * date：2022-03-23 23:11:13
*/
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 数组轮转k步
     * eg: nums: 1 2 3 4 5 6 7, k=3
     * 1. 7 6 5 4 3 2 1
     * 2. 5 6 7 4 3 2 1
     * 3. 5 6 7 1 2 3 4
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        //k = k%nums.length, 保证k小于数组长度
        k %= nums.length;
        //整个数据反转
        reverse(nums, 0, nums.length - 1);
        //0到k-1位子的数组反转
        reverse(nums, 0, k - 1);
        //k到最后位子的数组反转
        reverse(nums, k, nums.length - 1);
    }
    //反转数组start到end位子的数据
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            //start位子和end位子的数据交换
            //int temp = nums[start];
            //nums[start] = nums[end];
            //nums[end] = temp;
            //使用位运算进行数据交换
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            //start和end指针同时移动
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
