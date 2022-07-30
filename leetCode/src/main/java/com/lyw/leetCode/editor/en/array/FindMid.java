package com.lyw.leetCode.editor.en.array;

import java.util.PriorityQueue;

public class FindMid {
    public static void main(String[] args) {
        Solution solution = new FindMid().new Solution();
        int[] arr = new int[]{2, 4, 1, 5, 7};
        System.out.println(solution.findMid(arr));
    }

    class Solution {
        /**
         * 1.数组中找中位数，先构造（length/2 + 1）大小的小根堆
         * 2.遍历数组，先把堆填满，队列头最小，队列尾最大
         * 3.继续遍历，当队列头的值小于数组值时，替换掉队列头的值
         * 4.遍历完成时，小根堆里保存的是数组中较大部分的值
         * 5.数组长度为奇数时，直接返回队列头的值；数组长度为偶数时，返回队列前两个值的平均数
         * eg:
         * 2,4,1,5,7
         * 2,4,1  4,2,1
         * 4,2,5  5,4,2
         * 5,4,7  7,5,4
         */
        public double findMid(int[] arr) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length / 2 + 1) {
                    heap.add(arr[i]);
                } else {
                    if (heap.peek() < arr[i]) {
                        heap.poll();
                        heap.add(arr[i]);
                    }
                }
            }
            return arr.length / 2 == 0 ? (heap.poll() + heap.peek()) / 2 : heap.peek();
        }
    }
}
