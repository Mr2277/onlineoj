package com.huawei.leetcode.leetcode51_60;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LeetCode57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Map<Integer, Integer> regionMap = new TreeMap<>();
        Map<Integer, Integer> newRegionMap = new TreeMap<>();
        regionMap.put(newInterval[0], newInterval[1]);
        int key = 0, value = 0, lastKey = 0, lastValue = 0, row = 0;
        for (int i = 0; i < intervals.length; i++) {
            key = intervals[i][0];
            value = intervals[i][1];
            if (regionMap.containsKey(key)) {
                lastValue = regionMap.get(key);
                value = lastValue > value ? lastValue : value;
            }
            regionMap.put(key, value);
        }
        Iterator iterator = regionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            key = (int) entry.getKey();
            value = (int) entry.getValue();
            if (newRegionMap.isEmpty()) {
                newRegionMap.put(key, value);
                lastKey = key;
                lastValue = value;
            } else {
                if (lastValue >= key) {
                    if (value > lastValue) {
                        newRegionMap.put(lastKey, value);
                        lastValue = value;
                    }
                } else {
                    newRegionMap.put(key, value);
                    lastKey = key;
                    lastValue = value;
                }
            }
        }
        int[][] result = new int[newRegionMap.size()][2];
        iterator = newRegionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            key = (int) entry.getKey();
            value = (int) entry.getValue();
            result[row][0] = key;
            result[row][1] = value;
            row++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            int[] newInterval = new int[2];
            for (int i = 0; i < 2; i++) {
                newInterval[i] = scanner.nextInt();
            }
            int[][] result = insert(intervals, newInterval);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i][0] + " " + result[i][1]);
            }
        }
    }
}
