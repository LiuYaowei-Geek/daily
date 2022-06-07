package com.lyw.algorithms;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {6,1,4,3,2};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
