package com.lyw.algorithms.base;

import java.util.Arrays;

public class SortUtil {
    /**
     * 判断a是否比b小
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换array中第i个和第j个的位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 输出数组
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    /**
     * 判断数组是否是升序的
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
