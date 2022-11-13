//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge S
//ort Bucket Sort Radix Sort Counting Sort 
// 👍 2497 👎 547


package com.lyw.leetCode.editor.en;

import java.util.Arrays;
import java.util.Random;

//Java：T_912_Sort an Array
public class T_912_SortAnArray {
    public static void main(String[] args) {
        Solution solution = new T_912_SortAnArray().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 3, 6, 2, 7};
        System.out.println(Arrays.toString(nums));
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 1) {
                return nums;
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivot = new Random().nextInt(right - left + 1) + left;
            System.out.print("pivot-" + pivot);
            swap(nums, pivot, right);
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] - 1);
            quickSort(nums, p[1] + 1, right);
        }

        /**
         * 处理arr[L...R] 的函数
         * 默认以arr[R]做划分，arr[R] ->P, <P   =P   >P
         * 返回等于区域（左边界，右边界），所以返回一个长度为2的数组res， res[0], res[1]
         */
        private int[] partition(int[] nums, int left, int right) {
            System.out.print(" left-" + left);
            System.out.print(" right-" + right);
            //小于区右边界
            int less = left - 1;
            //大于区左边界
            int more = right;
            while (left < more) {
                if (nums[left] < nums[right]) {
                    swap(nums, ++less, left++);
                } else if (nums[left] > nums[right]) {
                    swap(nums, --more, left);
                } else {
                    left++;
                }
            }
            swap(nums, more, right);
            System.out.print(" left-" + left);
            System.out.print(" less-" + less);
            System.out.print(" right-" + right);
            System.out.print(" more-" + more);
            System.out.println(" " + Arrays.toString(nums));
            return new int[]{less + 1, more};
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}