//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the ith interval and inte
//rvals is sorted in ascending order by starti. You are also given an interval new
//Interval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in asce
//nding order by starti and intervals still does not have any overlapping interval
//s (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 105 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 105 
// 
// Related Topics Array 
// 👍 4719 👎 338


package com.lyw.leetCode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：T_57_Insert Interval
public class T_57_InsertInterval {
    public static void main(String[] args) {
        Solution solution = new T_57_InsertInterval().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = new int[]{4, 8};
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //时间复杂度O(n) 空间复杂度O(1)
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length < 1) {
                return new int[][]{newInterval};
            }
            int left = newInterval[0], right = newInterval[1];
            List<int[]> list = new ArrayList<>();
            int i = 0;
            //当前区间有边界小于插入区间做边界，直接添加
            while (i < intervals.length && intervals[i][1] < left) {
                list.add(intervals[i++]);
            }

            //当前区间左边界小于等于插入区间右边界，并且当前区间右边界大于等于插入区间左边界，代表两个区间有交集
            //持续调整插入区间的左右边界值
            while (i < intervals.length && intervals[i][0] <= right) {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
                i++;
            }

            //添加最终插入区间
            list.add(new int[]{left, right});

            //添加剩下的区间
            while (i < intervals.length) {
                list.add(intervals[i++]);
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
/**
 * 4 8
 * 3 8
 * 3 8
 */
//leetcode submit region end(Prohibit modification and deletion)
