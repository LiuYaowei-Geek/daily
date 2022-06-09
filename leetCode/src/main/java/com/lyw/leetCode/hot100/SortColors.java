package com.lyw.leetCode.hot100;
//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and b
//lue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant ex
//tra space? 
// Related Topics Array Two Pointers Sorting 
// 👍 9044 👎 396

import java.util.Arrays;

/**
  * questionId：75
  * question：Sort Colors
  * date：2022-03-14 22:39:15
*/
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        //int[] array = new int[]{2,0,2,1,1,0};
        //int[] array = new int[]{2,0,1};
        int[] array = new int[]{1, 0};
        solution.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //left指向0应该存放的位子，right指向2应该存放的位子，1不用管，0和2排好后，1自然就排好了
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i >= left) {
                nums[i] = nums[left];
                //left指针移动
                nums[left++] = 0;
                //swap(nums, i, left++);
                //移动i指针，因为i位子还需要处理一次，避免i++后i进位
                i = left - 1;
                continue;
            }
            if (nums[i] == 2 && right >= i) {
                //移动i指针，因为i位子还需要处理一次，避免i++后i进位
                nums[i--] = nums[right];
                //right指针移动
                nums[right--] = 2;
                //swap(nums, i--, right--);
            }
        }
    }

    //遍历过程中直接赋值，并且交换位置了
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
