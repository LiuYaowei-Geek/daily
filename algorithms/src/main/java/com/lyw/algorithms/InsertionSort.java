package com.lyw.algorithms;

import com.lyw.algorithms.base.SortUtil;

public class InsertionSort {

    /**
     * 插入排序
     *
     * @param array
     */
    private static void insertionSort(Comparable[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && SortUtil.less(array[j], array[j - 1]); j--) {
                SortUtil.exch(array, j, j - 1);
            }
        }
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 5, 2, 6, 1};
        insertionSort(array);
        SortUtil.show(array);
    }
}
