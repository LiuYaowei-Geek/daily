package com.lyw.sout;

/**
 * @author liuyaowei488
 * @date created in 2019-10-1 15:20
 */
public class HeapSizeSout {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }
}
