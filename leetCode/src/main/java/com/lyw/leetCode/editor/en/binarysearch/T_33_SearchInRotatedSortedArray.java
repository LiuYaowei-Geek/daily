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
// 👍 13995 👎 891


package com.lyw.leetCode.editor.en.binarysearch;


//Java：T_33_Search in Rotated Sorted Array
public class T_33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new T_33_SearchInRotatedSortedArray().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search(nums, target));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分，时间复杂度O(logn)  空间复杂度O(1)
         * 原始输入： 数组：0124567 ， target:0
         * 1. 有序数组旋转后，一半有序，一半右拐点
         * 2. mid == target时，直接返回mid
         * 3. 旋转后数组左半部分有序，如果target在[left, mid)区间中（mid位置为开区间，不用重复判断），舍掉右半部分，赋值right=mid-1；否则舍掉左半部分，left=mid+1;
         * 4. 旋转后数组右半部分有序，如果target在(mid, right]区间中（mid位置为开区间，不用重复判断），舍掉左半部分，赋值left=mid+1；否则舍掉右半部分，right=mid-1;
         * 5. 最终left=right， 判断值是否和target相等，相等返回索引，否则返回-1
         */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            //left < right
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

        public int search1(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            //left <= right
            while (left <= right) {
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
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}