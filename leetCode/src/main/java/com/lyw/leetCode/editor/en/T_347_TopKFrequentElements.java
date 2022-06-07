//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size. 
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority Que
//ue) Bucket Sort Counting Quickselect 
// 👍 9347 👎 375


package com.lyw.leetCode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：T_347_Top K Frequent Elements
public class T_347_TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new T_347_TopKFrequentElements().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度：O(Nlogk)，其中 N 为数组的长度。我们首先遍历原数组，并使用哈希表记录出现次数，每个元素需要 O(1) 的时间，共需O(N) 的时间。随后，我们遍历「出现次数数组」，由于堆的大小至多为 k，因此每次堆操作需要O(logk) 的时间，共需 O(Nlogk) 的时间。二者之和为 O(Nlogk)。
         * 空间复杂度：O(N)。哈希表的大小为 O(N)，而堆的大小为 O(k)，共计为 O(N)。
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            //用map维护数字和频次
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //用堆倒序排列频次
            Queue<Integer> heap = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
            heap.addAll(map.keySet());
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}