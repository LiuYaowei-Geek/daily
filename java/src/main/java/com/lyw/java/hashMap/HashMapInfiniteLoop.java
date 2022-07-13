package com.lyw.java.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证hashMap的线程安全性
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer, String> map = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {
        testUnsafeInMultiThreads();

        testNullInHashMap();
    }

    private static void testUnsafeInMultiThreads() {
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

    /**
     * hashMap可以允许put一个null的key
     * hashMap需要通过contains方法判断key是否包含null
     */
    private static void testNullInHashMap() {
        Map<Object, Object> cur1 = new HashMap<>();
        System.out.println(cur1.containsKey(null));
        System.out.println(cur1.containsValue(null));
        System.out.println(cur1.get(null));

        Map<Object, Object> cur2 = new HashMap<>();
        cur2.put(null, null);
        System.out.println(cur2.containsKey(null));
        System.out.println(cur2.containsValue(null));
        System.out.println(cur2.get(null));

    }
}
