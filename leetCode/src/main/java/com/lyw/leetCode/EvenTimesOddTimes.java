package com.lyw.leetCode;

import java.util.Arrays;
import java.util.List;

public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] oddTimesNum1 = new int[]{1, 2, 1, 3, 2};
        System.out.println(oddTimesNum1(oddTimesNum1));

        int[] oddTimesNum2 = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(oddTimesNum2(oddTimesNum2));
    }

    //数组中只有一个数出现了奇数次，其他都是偶数次，找出奇数次的数
    private static int oddTimesNum1(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        return eor;
    }

    //eor = a ^ b
    //eor != 0
    //eor必然有一个位置上是1
    //数组中有两个数出现了奇数次，其他都是偶数次，找出奇数次的数
    private static List<Integer> oddTimesNum2(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }

        //提取出eor二进制中最右侧的1
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int num : arr) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }
        return Arrays.asList(onlyOne, (eor ^ onlyOne));
    }
}
