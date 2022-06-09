package com.lyw.leetCode.hot100;
//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 
// 👍 4765 👎 125

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * questionId：40
  * question：Combination Sum II
  * date：2022-03-06 18:33:22
*/
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                // skip duplicates
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, remain- nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
