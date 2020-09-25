package com.huawei.leetcode.leetcode51_60;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LeetCode56 {

    public static int[][] merge(int[][] intervals) {
        Map<Integer, Integer> regionMap = new TreeMap<>();
        Map<Integer, Integer> newRegionMap = new TreeMap<>();
        int rows = intervals.length;
        int key = 0, value = 0, lastKey = 0, lastValue = 0;
        for (int i = 0; i < rows; i++) {
            key = intervals[i][0];
            value = intervals[i][1];
            if (regionMap.isEmpty()) {
                regionMap.put(key, value);
            } else {
                if (regionMap.containsKey(key)) {
                    lastValue = regionMap.get(key);
                    if (value > lastValue) {
                        regionMap.put(key, value);
                    }
                } else {
                    regionMap.put(key, value);
                }
            }
        }
        Iterator iterator = regionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Integer regionKey = (Integer) entry.getKey();
            Integer regitonValue = (Integer) entry.getValue();
            if (newRegionMap.isEmpty()) {
                newRegionMap.put(regionKey, regitonValue);
                lastKey = regionKey;
            } else {
                lastValue = newRegionMap.get(lastKey);
                if (lastValue >= regionKey ) {
                    if (regitonValue > lastValue) {
                        newRegionMap.put(lastKey, regitonValue);
                    }
                } else {
                    newRegionMap.put(regionKey, regitonValue);
                    lastKey = regionKey;
                }
            }
        }
        int[][] result = new int[newRegionMap.size()][2];
        iterator = newRegionMap.entrySet().iterator();
        rows = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            key = (int) entry.getKey();
            value = (int) entry.getValue();
            result[rows][0] = key;
            result[rows][1] = value;
            rows++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                }
            }
            int[][] result = merge(intervals);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i][0] + " " + result[i][1]);
            }
        }
    }
}
