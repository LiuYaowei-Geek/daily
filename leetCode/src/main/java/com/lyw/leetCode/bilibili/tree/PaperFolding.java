/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.lyw.leetCode.bilibili.tree;

/**
 * 一张纸对折n次，从上到下打印凸凹
 *
 * @author pangu
 * @version : PaperFolding.java, v 0.1 2022年04月26日 上午12:09 pangu Exp $
 */
public class PaperFolding {

    public static void main(String[] args) {
        int n = 6;
        printAllFolds(6);
    }

    private static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    /**
     * i是节点的层数
     * n是一共的层数
     * down = true ? 凹 : 凸
     *
     * @param i
     * @param n
     * @param down
     */
    private static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, n, false);
    }
}