package com.lyw.java.hashMap;

import java.util.HashMap;

/**
 * 验证hashMap的线程安全性
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer, String> map = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {
        map.put(5, "c");

        new Thread("thread1"){
            @Override
            public void run() {
                map.put(7, "b");
                System.out.println(map);
            };
        }.start();

        new Thread("thread2"){
            @Override
            public void run() {
                map.put(3, "a");
                System.out.println(map);
            };
        }.start();
    }
}
