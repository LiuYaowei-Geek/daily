package com.lyw.algorithms;

import com.lyw.algorithms.base.SortUtil;

/**
 * 快排
 */
public class QuickSort {

    private static void quickSort(Comparable[] array, int low, int high) {
        if (high <= low) return;
        int j = partition(array, low, high);
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, high);
    }

    /**
     * 快排切分
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = array[low];
        while (true) {
            while (SortUtil.less(array[++i], v)) if (i == high) break;
            while (SortUtil.less(v, array[--j])) if (j == low) break;
            if (i >= j) break;
            SortUtil.exch(array, i, j);
        }
        SortUtil.exch(array, low, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 5, 2, 6, 1};
        quickSort(array, 0, array.length - 1);
        SortUtil.show(array);
    }
}
