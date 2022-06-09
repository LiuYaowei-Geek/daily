package com.lyw.leetCode.hot100;
//A permutation of an array of integers is an arrangement of its members into a 
//sequence or linear order. 
//
// 
// For example, for arr = [1,2,3], the following are considered permutations of 
//arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1]. 
// 
//
// The next permutation of an array of integers is the next lexicographically gr
//eater permutation of its integer. More formally, if all the permutations of the 
//array are sorted in one container according to their lexicographical order, then
// the next permutation of that array is the permutation that follows it in the so
//rted container. If such arrangement is not possible, the array must be rearrange
//d as the lowest possible order (i.e., sorted in ascending order). 
//
// 
// For example, the next permutation of arr = [1,2,3] is [1,3,2]. 
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2]. 
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does n
//ot have a lexicographical larger rearrangement. 
// 
//
// Given an array of integers nums, find the next permutation of nums. 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [1,2,3]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,5]
//Output: [1,5,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 8986 👎 3039

import java.util.Arrays;

/**
  * questionId：31
  * question：Next Permutation
  * date：2022-03-02 21:38:41
*/
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = new int[] {1,2,4,3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 1、数组为：1243
         * 2、拐点数为2，最右侧比拐点大的数为3
         * 3、交换位子后数组为 1342
         * 4、把3往右所有的数(42)排序
         * 5、1324
         * @param nums
         */
    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        //判断数组是否全是递减
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //数组不是全递减的
        if (i >= 0) {
            //数组从后往前找
            int j = nums.length - 1;
            //nums[i] 为数组非递减的拐点
            //num[j]为最右边比拐点大的数
            while (nums[j] <= nums[i]) {
                j--;
            }
            //交换拐点和最右边比拐点大的数
            swap(nums, i, j);
        }
        //拐点位子当前为最右边比拐点大的数，把拐点位子往右所有的数排序
        //数组全是递减时，全部正序排
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
