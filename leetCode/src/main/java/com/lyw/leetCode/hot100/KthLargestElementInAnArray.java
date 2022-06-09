package com.lyw.leetCode.hot100;
//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
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
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 8652 👎 482

import java.util.Arrays;
import java.util.Random;

/**
  * questionId：215
  * question：Kth Largest Element in an Array
  * date：2022-03-25 18:18:09
*/
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargestWithRecursion(new int[] {3,2,1,5,6,4}, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestWithRecursion(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot++, i);
            }
        }
        swap(nums, pivot, high);
        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) {
            return nums[pivot];
        }
        // pivot is too small, so it must be on the right
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestWithIterative(int[] nums, int k) {
        // convert to index of k largest
        k = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            int i = l;
            for (int j = l + 1; j <= r; j++) {
                if (nums[j] < nums[l]) {
                    swap(nums, j, ++i);
                }
            }
            swap(nums, l, i);

            if (k < i) {
                r = i - 1;
            } else if (k > i) {
                l = i + 1;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public int findKthLargestWithRandom(int[] nums, int k) {
        int len = nums.length;
        return order(nums, 0, len - 1, len + 1 - k);
    }

    private int order(int[] nums, int s, int e, int n) {
        int random = new Random().nextInt(e - s + 1) + s;
        swap(nums, random, s);
        int pivot = nums[s], p1 = s;
        for (int i = s + 1; i <= e; i++) {
            if (nums[i] < pivot) {
                p1++;
                swap(nums, p1, i);
            }
        }
        swap(nums, s, p1);
        if (p1 == n - 1) {
            return pivot;
        } else if (p1 > n - 1) {
            return order(nums, s, p1 - 1, n);
        } else {
            return order(nums, p1 + 1, e, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
