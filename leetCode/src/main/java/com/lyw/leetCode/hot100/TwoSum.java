package com.lyw.leetCode.hot100;
//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics Array Hash Table 
// 👍 26335 👎 848

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目Id：1
 * 题目：Two Sum
 * 日期：2021-11-18 0/8:03:04
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.secondTwoSum(new int[] {2, 7, 11, 15}, 9)));
    }


    class Solution {
        /**
         * this is the first solution
         * use for-loop to solve the question
         */
        private int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
            throw new IllegalArgumentException("no match found");
        }

        /**
         * use hashmap to solve the problem
         * i put the value to hashmap's key
         * put index to hashmap's value
         * it's faster then two for-loop version
         * @param nums
         * @param target
         * @return
         */
        private int[] secondTwoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] {i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("no match found");
        }
    }

} 
