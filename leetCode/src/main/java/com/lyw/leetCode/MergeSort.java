package com.lyw.leetCode;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    /**
     * @param array 数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void process(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        //等价于 int mid = left + (right - left)/2;
        int mid = left + (right - left) >> 1;
        //递归排序左半边
        process(array, left, mid);
        //递归排序右半边
        process(array, mid + 1, right);
        //合并左右两个有序数组
        merge(array, left, mid, right);
    }

    /**
     * 合并两个有序数组
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array, int left, int mid, int right) {
        //辅助数组
        int[] help = new int[right - left + 1];
        //辅助数组index，初始威0
        int i = 0;
        //左半部分起始指针
        int p1 = left;
        //右半部分起始指针
        int p2 = mid + 1;
        //赋值并进行下标移动
        while (p1 <= mid && p2 <= right) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        //两个while只会进一个
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= right) {
            help[i++] = array[p2++];
        }
        //赋值给原数组
        for (i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
    }

}
