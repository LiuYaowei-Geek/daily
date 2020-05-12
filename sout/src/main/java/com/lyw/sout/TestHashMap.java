package com.lyw.sout;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(8);
        for (int i = 0; i < 9; i++) {
            map.put(i, i);
        }
        System.out.println(map);
    }
}
