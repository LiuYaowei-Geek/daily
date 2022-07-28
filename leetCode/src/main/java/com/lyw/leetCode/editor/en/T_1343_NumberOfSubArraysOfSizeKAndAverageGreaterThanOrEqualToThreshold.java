//Given an array of integers arr and two integers k and threshold, return the nu
//mber of sub-arrays of size k and average greater than or equal to threshold. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//Output: 3
//Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 r
//espectively. All other sub-arrays of size 3 have averages less than 4 (the thres
//hold).
// 
//
// Example 2: 
//
// 
//Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
//Output: 6
//Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. No
//te that averages are not integers.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 105 
// 1 <= arr[i] <= 104 
// 1 <= k <= arr.length 
// 0 <= threshold <= 104 
// 
// Related Topics Array Sliding Window 
// 👍 707 👎 65


package com.lyw.leetCode.editor.en;

//Java：T_1343_Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
public class T_1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {
        Solution solution = new T_1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口，时间复杂度O(n)，空间复杂度O(1)
         * 1.遍历数组
         * 2.当窗口长度小于k时，累加，right++;
         * 3.当窗口长度等于k时，并且和大于等于target时，计数加一
         * 4.当窗口长度大于k时，减去左边界，left++
         */
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int target = k * threshold;
            int count = 0, sum = 0;
            int left = 0, right = 0;
            while (right < arr.length) {
                if (right - left < k) {
                    sum += arr[right++];
                    if (right - left == k && sum >= target) {
                        count++;
                    }
                } else {
                    sum -= arr[left++];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}