package com.lyw.leetCode;


import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //i 到 n-1 位置上找最小值下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
