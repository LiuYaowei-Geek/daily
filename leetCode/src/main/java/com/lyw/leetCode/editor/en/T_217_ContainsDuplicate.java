//Given an integer array nums, return true if any value appears at least twice i
//n the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Hash Table Sorting 
// 👍 4494 👎 949


package com.lyw.leetCode.editor.en;

import java.util.HashSet;
import java.util.Set;

//Java：T_217_Contains Duplicate
public class T_217_ContainsDuplicate{
    public static void main(String[] args) {
        Solution solution = new T_217_ContainsDuplicate().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int cur : nums) {
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}