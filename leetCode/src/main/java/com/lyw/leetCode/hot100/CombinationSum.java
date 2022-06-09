package com.lyw.leetCode.hot100;
//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// It is guaranteed that the number of unique combinations that sum up to target
// is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 
// 👍 9968 👎 217

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：39
  * question：Combination Sum
  * date：2022-03-06 18:23:49
  * 参考：https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
*/
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        solution.combinationSum(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //不是必需
        //Arrays.sort(candidates);
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
                tempList.add(nums[i]);
                // not i + 1 because we can reuse same elements
                backtrack(res, tempList, nums, remain- nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
