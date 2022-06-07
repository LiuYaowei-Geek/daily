package com.lyw.leetCode.bilibili.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度O(N*logN)
 * master公式:a=2, b=2,d=1
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] helper = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            helper[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= M) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }
        for (int j = 0; j < helper.length; j++) {
            arr[L + j] = helper[j];
        }
    }
}
