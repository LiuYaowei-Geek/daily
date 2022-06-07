package com.lyw.java.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache2 {
    private Map<Integer, Integer> map;
    private final int cacheSize;

    public LruCache2(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        this.cacheSize = capacity;
    }
}
