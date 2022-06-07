package com.lyw.leetCode.bilibili.sort;

import java.util.Arrays;

/**
 * 快排
 * 时间复杂度O(N*logN)
 * 最差情况 O(N^2)
 * 空间复杂度O(logN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //arr[L...R]排序
    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            //小分区
            quickSort(arr, L, p[0] - 1);
            //大分区
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 处理arr[L...R] 的函数
     * 默认以arr[R]做划分，arr[R] ->P, <P   =P   >P
     * 返回等于区域（左边界，右边界），所以返回一个长度为2的数组res， res[0], res[1]
     */
    private static int[] partition(int[] arr, int L, int R) {
        //小于区右边界
        int less = L - 1;
        //大于区左边界
        int more = R;
        //L表示当前数组的位置，arr[R] -> 划分值
        while (L < more) {
            //当前数小于划分值
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
                //当前数大于划分值
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
