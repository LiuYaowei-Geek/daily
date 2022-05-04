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
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
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
// 👍 31260 👎 990


package com.lyw.leetCode.editor.en.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：T_1_Two Sum
public class T_1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new T_1_TwoSum().new Solution();
        // TO TEST
        int[] nums = new int[]{3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //hash表方法，时间复杂度O(n)  空间复杂度O(n)
    //遍历时间复杂度O(n) ， hash表空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        //key为数值，value为索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //先判断，再放入map，避免[3,3] 6这种类型的数据
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}