package com.lyw.leetCode.hot100;
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
// 👍 12476 👎 495

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
  * questionId：56
  * question：Merge Intervals
  * date：2022-03-10 08:41:26
*/
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(solution.merge(new int[][]{{2,6}, {1,3}, {8, 10}, {15, 18}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //二维数组，按照每行第一个元素，从小到大排序
        //Arrays.sort(intervals, (o1,o2) -> o1[0]-o2[0]);
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

        //用list存储每次归并的区间
        List<int[]> tempList = new ArrayList<>();
        //第一行的区间开始值和结束值
        int firstStart = intervals[0][0];
        int firstEnd = intervals[0][1];
        //从第二行开始比较
        int i = 1;
        while (i < intervals.length) {
            //每一行的区间开始值和结束值
            int eachStart = intervals[i][0];
            int eachEnd = intervals[i][1];
            //如果当前行的区间开始值小于上一行的区间结束值，说明区间有交集
            if (eachStart <= firstEnd) {
                //上一行的区间结束值，取当前行和上一行中区间结束值最大的那个
                firstEnd = Math.max(firstEnd, eachEnd);
            } else {
                //区间没交集，存储上一行的区间值
                tempList.add(new int[] {firstStart, firstEnd});
                //区间比较的基准值替换
                firstStart = eachStart;
                firstEnd = eachEnd;
            }
            i++;
        }
        //存储最后一次的区间值
        tempList.add(new int[] {firstStart, firstEnd});
        //转换为二维数组返回
        return tempList.toArray(new int[tempList.size()][]);

        //int[][] res = new int[tempList.size()][2];
        //for (int j = 0; j < tempList.size(); j++) {
        //    res[j][0] = tempList.get(j)[0];
        //    res[j][1] = tempList.get(j)[1];
        //}
        //return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
