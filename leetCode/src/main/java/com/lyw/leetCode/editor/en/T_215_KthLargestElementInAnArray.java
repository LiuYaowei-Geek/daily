//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 11124 👎 567


package com.lyw.leetCode.editor.en;

import java.util.Random;

//Java：T_215_Kth Largest Element in an Array
public class T_215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new T_215_KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] arr = new int[]{1, 3, 2, 7, 5};
        System.out.println(solution.findKthLargest(arr, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 快速选择，查找数组中第k小的数，时间复杂度平均为O(n)。使用random将数组分区，使得左边的数都小于random位置的数，右边的数都大于random位置的数
         *
         * 1.在数组长度闭区间中任找一个数random, nums[random]记为pivot
         * 2.将random和left位置数字交换
         * 3.从left+1位置遍历数组，当nums[i]小于pivot时，计数count加一，并交换i位置和count位置的数
         * 4.交换left位置和count位置数据，使得pivot左边数字都小于pivot，右边都大于pivot
         * 5.判断count+1是否和k相等，相等直接返回pivot
         * 6.count+1大于k时，递归找[left, count-1]区间
         * 7.count+1小于k时，递归找[count+1, right]区间
         */
        public int findKthLargest(int[] nums, int k) {
            int length  = nums.length;
            return quickSelect(nums, 0, length - 1, length - k + 1);
        }

        /**
         * 快速选择，在left和right中，找第k小的数
         * 1, 3, 2, 7, 5
         * 5, 3, 2, 7, 1
         * 5, 3, 2, 1, 7
         * 1, 3, 2, 5, 7
         */
        private int quickSelect(int[] nums, int left, int right, int k) {
            //left到right中随机一个整数，闭区间
            int random = new Random().nextInt(right - left + 1) + left;
            swap(nums, random, left);
            int pivot = nums[left], count = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    count++;
                    swap(nums, count, i);
                }
            }
            swap(nums, left, count);
            if (count + 1 == k) {
                return pivot;
            } else if (count + 1 > k) {
                return quickSelect(nums, left, count - 1, k);
            } else {
                return quickSelect(nums, count + 1, right, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}