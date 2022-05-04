//Given an array of intervals intervals where intervals[i] = [starti, endi], ret
//urn the minimum number of intervals you need to remove to make the rest of the i
//ntervals non-overlapping. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overla
//pping.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals no
//n-overlapping.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics Array Dynamic Programming Greedy Sorting 
// 👍 3904 👎 114


package com.lyw.leetCode.editor.en.interval;

import java.util.Arrays;

//Java：T_435_Non-overlapping Intervals
public class T_435_NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new T_435_NonOverlappingIntervals().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{
                {0, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {4, 6}
        };
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //greedy，时间复杂度O(nlogn),遍历是O(n)，但是初始排序是O(nlogn)。空间复杂度O(logn)，排序占用O(logn)
        //因为是求最小去除数，所以存在交集时，右边界值取最小的，不存在交集时，右边界值取当前区间的右边界
        public int eraseOverlapIntervals(int[][] intervals) {
            //base case
            if (intervals == null || intervals.length < 2) {
                return 0;
            }
            //数组按照第一个数字的大小升序排列
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            //记录初始右边界
            int end = intervals[0][1];
            //需要去除的区间个数
            int res = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                //当前区间和之前的区间存在交集
                if (cur[0] < end) {
                    //返回值加1
                    res++;
                    //右边界设置为最小的右边界值
                    end = Math.min(cur[1], end);
                } else {
                    //当前区间不存在交集时，end设置为当前区间的右边界
                    end = cur[1];
                }
            }
            return res;
        }
    }
    /**
     * 16 25 34 45
     *
     * 49  58 67
     */
//leetcode submit region end(Prohibit modification and deletion)

}