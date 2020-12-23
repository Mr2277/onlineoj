package com.huawei.leetcode.leetcode1_1000.leetcode701_800.leetcode781_790;

import java.util.*;

public class LeetCode787 {
    static class Location {
       int airport;
       int transfer;
       int costs;
       Location(int airport, int transfer, int costs) {
           this.airport = airport;
           this.transfer = transfer;
           this.costs = costs;
       }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Integer>> flightMap = new HashMap<>();
        Map<String, Integer> priceMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (!flightMap.containsKey(flights[i][0])) {
                List<Integer> list = new ArrayList<>();
                list.add(flights[i][1]);
                flightMap.put(flights[i][0], list);
            } else {
                List<Integer> list = flightMap.get(flights[i][0]);
                list.add(flights[i][1]);
                flightMap.put(flights[i][0], list);
            }
            String key = flights[i][0] + "->" + flights[i][1];
            priceMap.put(key, flights[i][2]);
        }
        Location cur = new Location(src, K, 0);
        Queue<Location> queue = new LinkedList<>();
        queue.add(cur);
        List<Location> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (!flightMap.get(cur.airport).isEmpty()) {
                    for (Integer nextAirport : flightMap.get(cur.airport)) {
                        Integer cost = priceMap.get(cur.airport + "->" + nextAirport);
                        if (dst == nextAirport) {
                            Location next = new Location(nextAirport, K, cost + cur.costs);
                            // queue.add(next);
                            result.add(next);
                        } else {
                            K--;
                            if (K >= 0) {
                                Location next = new Location(nextAirport, K, cost + cur.costs);
                                queue.add(next);
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Location location : result) {
            if (location.costs < min) {
                min = location.costs;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }

    public static void main(String[] args) {
        //5 [[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]] 2 1 1
        /*
        int[][] edges = new int[][] {
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},{0,4,10],[3,1,1],[1,4,3]};
        new LeetCode787().findCheapestPrice(3, edges, 0, 2, 0);
        */
        /*&
        short s = 1;
        s = (short) (s + 1);
        System.out.println(s);
        */
        Map<Integer, String> map = new LinkedHashMap<>(1, 0.75f, true);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.get(1);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println((Integer) entry.getKey() + (String)entry.getValue());
        }
    }
}
