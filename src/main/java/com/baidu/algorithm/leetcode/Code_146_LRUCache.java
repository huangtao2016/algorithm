package com.baidu.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Code_146_LRUCache extends LinkedHashMap {
    private int capacity;
    public Code_146_LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int)super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
