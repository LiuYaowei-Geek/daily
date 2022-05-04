package com.lyw.leetCode.bilibili.Recursion;

public class NQueens {
    public static void main(String[] args) {

    }

    public static int getRes(int n) {
        if (n < 1) {
            return 0;
        }
        //record[i] i行的皇后放在了第几列
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * record[0..i-1]的皇后一定符合要求
     * 目前来到了第i行
     * record[0..i]表示之前的行，放了的皇后位置
     * n代表整体一共有多少行
     * 返回值是。摆完所有的皇后，合理的摆法有多少种
     *
     * @param i
     * @param record
     * @param n
     * @return
     */
    public static int process(int i, int[] record, int n) {
        //终止行，代表record符合要求，直接返回
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 判断不共行，不共列，不共斜线
     * 判断斜线使用45度斜率判断，即横坐标差值的绝对值等于纵坐标差值的绝对值
     *
     * @param record
     * @param i
     * @param j
     * @return
     */
    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
