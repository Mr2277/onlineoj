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

    Map<Integer, List<Integer>> flightMap = new HashMap<>();
    Map<String, Integer> priceMap = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

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
        int[] flag = new int[n];
        dfs(K, src, dst, 0, flag);
        return result;
    }
    public int result = -1;
    public void dfs(int step, int cur, int dst, int cost, int[] flag) {
        if (cur == dst) {
            result = result == -1 ? cost : Integer.min(result, cost);
            return;
        }
        flag[cur] = 1;
        if (step > -1) {
            if (flightMap.containsKey(cur)) {
                List<Integer> dsts = flightMap.get(cur);
                for (Integer nextAirport : dsts) {
                    String flight = cur + "->" + nextAirport;
                    int total = cost + priceMap.get(flight);
                    if (flag[nextAirport] == 0 && (result == -1 || (result != -1 && total < result))) {
                        dfs(step - 1, nextAirport, dst, total, flag);
                    }
                }
            }
        }
        flag[cur] = 0;
    }

    public static void main(String[] args) {


        /*
        int[][] edges = new int[][] {
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},
                {0, 4, 10},
                {3, 1, 1},
                {1, 4, 3}
        };
        new LeetCode787().findCheapestPrice(5, edges, 2, 1, 1);
        */
        //4 [[0,1,1],[0,2,5],[1,2,1],[2,3,1]] 0 3 1
        /*
        int[][] edges = new int[][] {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        */
        int[][] edges = new int[][] {
                {10,14,43},
            {1,12,62},
            {4,2,62},
            {14,10,49},{9,5,29},{13,7,53},{4,12,90},{14,9,38},{11,2,64},{2,13,92},{11,5,42},{10,1,89},{14,0,32},{9,4,81},{3,6,97},{7,13,35},{11,9,63},{5,7,82},{13,6,57},{4,5,100},{2,9,34},{11,13,1},{14,8,1},{12,10,42},{2,4,41},{0,6,55},{5,12,1},{13,3,67},{3,13,36},{3,12,73},{7,5,72},{5,6,100},{7,6,52},{4,7,43},{6,3,67},{3,1,66},{8,12,30},{8,3,42},{9,3,57},{12,6,31},{2,7,10},{14,4,91},{2,3,29},{8,9,29},{2,11,65},{3,8,49},{6,14,22},{4,6,38},{13,0,78},{1,10,97},{8,14,40},{7,9,3},{14,6,4},{4,8,75},{1,6,56}};
        new LeetCode787().findCheapestPrice(15, edges, 1, 4, 10);
    }
}
