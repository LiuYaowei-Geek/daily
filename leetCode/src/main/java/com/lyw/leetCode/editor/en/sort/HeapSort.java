package com.lyw.leetCode.editor.en.sort;

import java.util.Arrays;

/**
 * 堆排序（结构是完全二叉树）
 * 时间复杂度O(N*logN)
 * 空间复杂度O(1)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //某个数现在处于index位置，往上继续移动
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //某个数在index位置，能否往下移动
    private static void heapify(int[] arr, int index, int heapSize) {
        //左孩子的下标
        int left = index * 2 + 1;
        //下方还有孩子的时候
        while (left < heapSize) {
            //两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父节点和较大孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
