package com.lyw.leetCode.hot100;
//Given an unsorted integer array nums, return the smallest missing positive int
//eger. 
//
// You must implement an algorithm that runs in O(n) time and uses constant extr
//a space. 
//
// 
// Example 1: 
// Input: nums = [1,2,0]
//Output: 3
// Example 2: 
// Input: nums = [3,4,-1,1]
//Output: 2
// Example 3: 
// Input: nums = [7,8,9,11,12]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Hash Table 
// 👍 8761 👎 1260

/**
  * questionId：41
  * question：First Missing Positive
  * date：2022-03-07 22:12:07
*/
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[] {-1,-2, 0, 1, 1,60,40,43}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j ];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
