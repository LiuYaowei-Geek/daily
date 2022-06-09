package com.lyw.leetCode.hot100;
//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 9313 👎 148

import java.util.ArrayList;
import java.util.List;

/**
  * questionId：78
  * question：Subsets
  * date：2022-03-06 15:07:33
*/
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        solution.subsets(new int[] {1,2,2,3,4}).forEach(System.out::println);
        solution.subsets(new int[] {1,2,3,4}).forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //结果不要求有序时，不用排序
        //Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    /**
     * i和start控制递归循环
     * tempList是子集列表
     * res每次添加tempList到自己里面
     *
     * 以{1，2，3，4}为例，按照（nums.length = 4）循环4次，每次tempList数据变化如下
     * 1、[[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 4], [1, 3], [1, 3, 4], [1, 4]]
     * 2、[[2], [2, 3], [2,3,4], [2,4]]
     * 3、[[3], [3,4]]
     * 4、[[4]]
     * @param res
     * @param tempList
     * @param nums
     * @param start
     */
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int [] nums, int start) {
        //不能使用res.add(tempList)，不然每次递归循环时，tempList值改变，res中数据也会跟着改变
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            //删除tempList最后一位
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
