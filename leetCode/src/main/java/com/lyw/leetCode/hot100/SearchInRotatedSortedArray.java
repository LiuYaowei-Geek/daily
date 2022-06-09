package com.lyw.leetCode.hot100;
//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is possibly rotated at an unknow
//n pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, retur
//n the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 12855 👎 848

/**
  * questionId：33
  * question：Search in Rotated Sorted Array
  * date：2022-03-02 23:41:50
*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 0));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left到mid有序递增
            if (nums[left] <= nums[mid]) {
                //目标值在lef和mid之间
                if (target >= nums[left] && target < nums[mid]) {
                    //mid到right不用考虑，舍弃
                    right = mid - 1;
                } else {
                    //目标值被旋转到mid至right间或目标值本身就在mid右侧，left至mid不用考虑，舍弃
                    left = mid + 1;
                }
                //left到mid中有拐点，先增后减
            } else {
                //left-mid无序，mid-right有序递增
                if (target > nums[mid] && target <= nums[right]) {
                    //left-mid不用考虑，移动left
                    left = mid + 1;
                } else {
                    //mid-right不用考虑，移动right
                    right = mid - 1;
                }
            }
        }
        //left >= right，nums[left]为二分最后一个数
        return nums[left] == target ? left : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
