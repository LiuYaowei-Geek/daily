package com.lyw.algorithms;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (target > array[mid]) {
                left = mid + 1;
            } else if (target < array[mid]){
                right = mid - 1;
            } else {
                return mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int target = 4;
        int mid = binarySearch(array, target);
        System.out.println(mid);
    }
}
