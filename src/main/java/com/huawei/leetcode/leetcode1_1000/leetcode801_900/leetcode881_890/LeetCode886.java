package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode881_890;


import java.util.*;

public class LeetCode886 {
    /*
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] colors = new int[N + 1];

        for (int i = 1; i < N + 1; i++){
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue=new LinkedList<>();
            colors[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int color = colors[curr];
                int nextColor = color == 1 ? 2 : 1;
                for(int neighbor : graph.get(curr)) {
                    if(colors[neighbor] == 0) {
                        colors[neighbor] = nextColor;
                        queue.add(neighbor);
                    } else if (colors[neighbor] != nextColor) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
    */
    public static boolean possibleBipartition(int N, int[][] dislikes) {
       Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();
       for (int[] dis : dislikes) {
           if (dislikeMap.containsKey(dis[0])) {
               Set<Integer> set = new HashSet<>();
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           } else {
               Set<Integer> set = dislikeMap.get(dis[0]);
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           }
       }
       return false;
    }
    public static void main(String[] args) {
       int[][] dislikes = new int[][] {{1,2},{1,3},{2,4}};
       possibleBipartition(4, dislikes);
    }
}
