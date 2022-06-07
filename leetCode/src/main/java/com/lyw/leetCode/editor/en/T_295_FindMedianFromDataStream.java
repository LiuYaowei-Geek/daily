//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value and the median is the mean of the two mid
//dle values. 
//
// 
// For example, for arr = [2,3,4], the median is 3. 
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5. 
// 
//
// Implement the MedianFinder class: 
//
// 
// MedianFinder() initializes the MedianFinder object. 
// void addNum(int num) adds the integer num from the data stream to the data st
//ructure. 
// double findMedian() returns the median of all elements so far. Answers within
// 10-5 of the actual answer will be accepted. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
// 
//
// 
// Constraints: 
//
// 
// -105 <= num <= 105 
// There will be at least one element in the data structure before calling findM
//edian. 
// At most 5 * 104 calls will be made to addNum and findMedian. 
// 
//
// 
// Follow up: 
//
// 
// If all integer numbers from the stream are in the range [0, 100], how would y
//ou optimize your solution? 
// If 99% of all integer numbers from the stream are in the range [0, 100], how 
//would you optimize your solution? 
// 
// Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 
//
// 👍 7004 👎 132


package com.lyw.leetCode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：T_295_Find Median from Data Stream
public class T_295_FindMedianFromDataStream {
    public static void main(String[] args) {
//        Solution solution = new T_295_FindMedianFromDataStream().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        //保存small half，samll长度和large想等或者大一，从大到小顺序
        private Queue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        //保存large half，从小到大顺序
        private Queue<Integer> large = new PriorityQueue<>();

        //是否为偶数
        private boolean isEven = true;

        public MedianFinder() {

        }

        /**
         * O(logn)
         *
         * @param num
         */
        public void addNum(int num) {
            //偶数长度时，先将数添加到大根堆里，再弹出到小根堆中，保证小根堆的长度比大根堆大一，并且数字都小于大根堆数字
            if (isEven) {
                large.offer(num);
                //large.poll()弹出large中最小的
                small.offer(large.poll());
            } else {
                //奇数长度时，先将数添加到小根堆里，再弹出到大根堆中，保证添加完数字后小根堆的长度和大根堆一样，并且数字都小于大根堆数字
                small.offer(num);
                //small.poll()弹出small中最大的
                large.offer(small.poll());
            }
            //添加一个数后，偶数标识取反
            isEven = !isEven;
        }

        /**
         * O(1)
         *
         * @return
         */
        public double findMedian() {
            if (isEven) {
                //取small中最大的和large中最小的，除以2.0保证结果是double类型，除以2是整数
                return (small.peek() + large.peek()) / 2.0;
            } else {
                return small.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}