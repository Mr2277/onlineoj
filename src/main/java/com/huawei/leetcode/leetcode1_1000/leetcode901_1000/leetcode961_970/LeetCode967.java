package com.huawei.leetcode.leetcode1_1000.leetcode901_1000.leetcode961_970;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode967 {

    public int[] numsSameConsecDiff(int n, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (i - k >= 0) {
                if (!map.containsKey(i)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i - k);
                    map.put(i, list);
                } else {
                    List<Integer> list = map.get(i);
                    list.add(i - k);
                    map.put(i, list);
                }
            }
            if (i + k < 10) {
                if (!map.containsKey(i)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i + k);
                    map.put(i, list);
                } else {
                    List<Integer> list = map.get(i);
                    list.add(i + k);
                    map.put(i, list);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (Integer key : map.keySet()) {
            queue.add(String.valueOf(key));
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                Integer key = Integer.parseInt(cur.substring(cur.length() - 1, cur.length()));
                List<Integer> list = map.get(key);
                for (Integer integer : list) {
                    String next = cur + String.valueOf(integer);
                    if (next.length() < n) {
                        queue.add(next);
                    } else {
                        next = next.replaceFirst("^0*", "");
                        if (next.length() == n) {
                            result.add(next);
                        }
                    }
                }
            }
        }
        result = result.stream().distinct().collect(Collectors.toList());
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = Integer.parseInt(result.get(i));
        }
        return array;
    }

    public static void main(String[] args) {
        new LeetCode967().numsSameConsecDiff(2, 0);
    }
}
