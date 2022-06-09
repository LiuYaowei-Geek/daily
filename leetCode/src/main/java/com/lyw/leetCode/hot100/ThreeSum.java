package com.lyw.leetCode.hot100;
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 15180 👎 1462

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
  * questionId：15
  * question：3Sum
  * date：2022-01-09 23:30:33
*/
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            res.add(Arrays.asList(0, 0, 0));
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] == nums[j] && nums[j] != nums[i]) {
                    continue;
                }
                int target = -nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (target == nums[k]) {
                        res.add(Arrays.asList(nums[i], nums[j], target));
                        break;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
