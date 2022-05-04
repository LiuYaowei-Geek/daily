//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 13265 👎 515


package com.lyw.leetCode.editor.en;

import java.util.*;

//Java：T_56_Merge Intervals
public class T_56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new T_56_MergeIntervals().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };
        Arrays.sort(intervals);
        System.out.println(Arrays.toString(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //数组区间合并
        //时间复杂度 O(nlogn)，遍历是O(n)，排序是O(nlogn)，所有最终时间复杂度是O(nlogn)
        //空间复杂度 O(logn) 排序需要使用O(logn)
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length < 1 || intervals[0].length < 1) {
                return null;
            }

            //按照数组中第一个数组升序排列
            //时间复杂度 O(nlogn)
            //空间复杂度 O(logn)
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
//            Arrays.sort(intervals, new MyComparator());
            List<int[]> res = new ArrayList<>();
            //时间复杂度 O(n)
            for (int[] interval : intervals) {
                //区间开始值
                int start = interval[0];
                //区间结束值
                int end = interval[1];

                //res中最后一个区间的结束值小于当前区间的开始值，直接新增一个区间
                if (res.size() == 0 || res.get(res.size() - 1)[1] < start) {
                    res.add(new int[]{start, end});
                } else {
                    //res中最后一个区间的结束值大于等于当前区间的开始值，重新设置res中最后一个区间的结束值
                    res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], end);
                }
            }

            //list转数组直接返回
            return res.toArray(new int[res.size()][]);
        }

        public class MyComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}