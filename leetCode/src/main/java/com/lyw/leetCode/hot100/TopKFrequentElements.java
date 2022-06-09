package com.lyw.leetCode.hot100;
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
// 👍 8750 👎 359

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
  * questionId：347
  * question：Top K Frequent Elements
  * date：2022-04-10 15:53:55
*/
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        System.out.println(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
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
