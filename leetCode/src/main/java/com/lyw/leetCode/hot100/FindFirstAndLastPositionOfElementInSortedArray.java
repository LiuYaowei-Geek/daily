package com.lyw.leetCode.hot100;
//Given an array of integers nums sorted in non-decreasing order, find the start
//ing and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 9526 👎 273

/**
  * questionId：34
  * question：Find First and Last Position of Element in Sorted Array
  * date：2022-03-03 00:42:32
*/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        //left 和 right位子可能都等于target，所以判断使用left <= right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //找最左侧等于target的值，所以nums[mid] >= target时依然需要移动right指针
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                res = mid;
            }
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        //找最右侧等于target的值，所以nums[mid] <= target时依然需要移动left指针
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                res = mid;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
