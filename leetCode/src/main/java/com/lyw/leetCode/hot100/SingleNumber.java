package com.lyw.leetCode.hot100;
//Given a non-empty array of integers nums, every element appears twice except f
//or one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only c
//onstant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -3 * 104 <= nums[i] <= 3 * 104 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
// Related Topics Array Bit Manipulation 
// 👍 9356 👎 330

import java.util.HashSet;
import java.util.Set;

/**
  * questionId：136
  * question：Single Number
  * date：2022-03-20 15:33:59
*/
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[]{2,2,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int singleNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }
        return set.toArray(new Integer[]{})[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
