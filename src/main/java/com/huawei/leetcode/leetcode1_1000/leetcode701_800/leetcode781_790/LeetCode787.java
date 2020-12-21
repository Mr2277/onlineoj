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
        System.out.println(priceMap.size());
        System.out.println(flightMap.size());
        Location cur = new Location(src, K, 0);
        Queue<Location> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                for (Integer nextAirport : flightMap.get(cur.airport)) {
                    Integer cost = priceMap.get(cur.airport + "->" + nextAirport);
                    if (dst == nextAirport) {
                        Location next = new Location(nextAirport, K, cost + cur.costs);
                        queue.add(next);
                    } else {
                        K--;
                        if (K >= 0) {
                            Location next = new Location(nextAirport, K, cost + cur.costs);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0, 1, 100}, {1, 2, 100},{0, 2, 500}};
        new LeetCode787().findCheapestPrice(3, edges, 0, 2, 1);
    }
}
