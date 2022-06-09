package com.lyw.leetCode.hot100;
//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 
// 👍 9406 👎 175

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：46
  * question：Permutations
  * date：2022-03-06 15:13:56
*/
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[] {1,2,3}).forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //结果不要求有序时，不用排序
        //Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }
        /**
         * 起始条件为i = start时，求子集
         * 起始条件为i = 0时，求全集
         */
        for (int i = 0; i < nums.length; i++) {
            //element already exists, skip
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
