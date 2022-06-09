package com.lyw.leetCode.hot100;
//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 
// 👍 4577 👎 90

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * questionId：47
  * question：Permutations II
  * date：2022-03-06 16:36:24
*/
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[] {1, 1, 2}).forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    /**
     *
     * @param res
     * @param tempList
     * @param nums
     * @param used 初始化时全为false。元素中true-使用过  false-没用过
     */
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            //1、i位子元素用过直接continue
            //2、i > 0 并且nums[i] == nums[i - 1] 并且i-1位子元素没用过 直接continue
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
