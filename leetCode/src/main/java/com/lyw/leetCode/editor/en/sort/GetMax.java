package com.lyw.leetCode.editor.en.sort;


public class GetMax {

    /**
     * 数组取最大值
     * 时间复杂度O(logN)
     * @param arr
     * @return
     */
    private static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
