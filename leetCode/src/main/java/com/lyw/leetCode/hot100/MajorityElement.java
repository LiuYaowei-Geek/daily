package com.lyw.leetCode.hot100;
//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. You
// may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in O(1) space? Relat
//ed Topics Array Hash Table Divide and Conquer Sorting Counting 
// 👍 9094 👎 327

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
  * questionId：169
  * question：Majority Element
  * date：2022-03-23 22:26:06
*/
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElementWithSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

        public int majorityElementWithHashMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int val : nums) {
                //不用判断key是否包含
                map.put(val, map.getOrDefault(val, 0) + 1);
                if (map.get(val) > nums.length / 2) {
                    return val;
                }
                //if (!map.containsKey(val)) {
                //    map.put(val, 1);
                //} else {
                //    map.put(val, map.get(val) + 1);
                //    if (map.get(val) > nums.length / 2) {
                //        return val;
                //    }
                //}
            }
            return 0;
        }
        //摩尔投票算法
        public int majorityElementWithMooreVote(int[] nums) {
        //count用于计数，记录一个数res，遍历数相等时就加一，不等时就减一。res为返回结果
            int count = 0, res = 0;
            for (int val : nums) {
                //count为0说明第一次出现，res赋值val
                if (count == 0) {
                    res = val;
                }
                //当前值和res不等时，count-1
                if (val != res) {
                    count--;
                } else {
                    //当前值和res相等时，count+1
                    count++;
                }
            }
            return res;
        }

        public int majorityElementWithBitManipulation(int[] nums) {
            int[] bit = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    bit[i] += (num >> i) & 1;
                }
            }
            int majority = 0;
            for (int i = 0; i < 32; i++) {
                bit[i] = bit[i] > (nums.length / 2)? 1 : 0;
                majority += bit[i] << i;
            }
            return majority;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
