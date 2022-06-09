package com.lyw.leetCode.hot100;
//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Hash Table Union Find 
// 👍 8689 👎 382

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
  * questionId：128
  * question：Longest Consecutive Sequence
  * date：2022-03-20 14:39:00
*/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //0 1 2 3 4 5
    //0 1 1 2
    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        //连续数最大长度
        int res = 1;
        //start连续数起始指针，end连续数结束指针
        int start = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //end右移一位
            end = i + 1;
            //i位子和i+1位置的数连续
            if (nums[i] + 1 == nums[i + 1]) {
                res = Math.max(res, end - start + 1);
            //i位子和i+1位置的数相等
            } else if (nums[i] == nums[i + 1]) {
                //起始指针右移一位，抵消i位子和i+1位置的数相等对长度计算的影响
                start++;
            //i位子和i+1位置的数不相等
            } else {
                //起始指针指向i+1位子
                start = i + 1;
            }
        }
        return res;
    }

    public int longestConsecutiveWithSet(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;

                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
