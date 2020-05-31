package com.lasam.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuhao
 * @date 2020/5/25 23:35
 */
public class P146 {

    private static class LRUCache {

        Map<Integer, Integer> m;
        List<Integer> list = new ArrayList<>();
        int max;

        public LRUCache(int capacity) {
            m = new HashMap<>(capacity, 1);
            max = capacity;
        }

        public int get(int key) {
            Integer result = m.get(key);
            if (result == null) {
                return -1;
            }

            list.removeIf(e -> e == key);
            list.add(key);
            return result;
        }

        public void put(int key, int value) {
            //add
            if (get(key) == -1) {
                m.put(key, value);
                list.add(key);
                if (m.size() > max) {
                    int last = list.remove(0);
                    m.remove(last);
                }
            }
            //update
            else {
                m.put(key, value);
                list.removeIf(e -> e == key);
                list.add(key);
            }
        }
    }
}
