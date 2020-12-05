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
           if (!dislikeMap.containsKey(dis[0])) {
               Set<Integer> set = new HashSet<>();
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           } else {
               Set<Integer> set = dislikeMap.get(dis[0]);
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           }
       }
       int[] colors = new int[N];
       Iterator iterator = dislikeMap.entrySet().iterator();
       while (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           Integer key = (Integer) entry.getKey();
           Set<Integer> set = (Set<Integer>) entry.getValue();
           List<Integer> list = new ArrayList<>(set);
           int target = 1;
           if (colors[key -1] != 0) {
               target = colors[key - 1];
           }
           for (Integer integer : list) {
               if (integer != 0) {
                   target = integer == 1 ? 2 : 1;
               }
           }
           dfs(dislikeMap, colors, target, key);
       }
       return false;
    }
    public static boolean result = true;
    public static void dfs (Map<Integer, Set<Integer>> dislikeMap, int[] colors, int target, int cur) {
        if (dislikeMap.containsKey(cur)) {
            Set<Integer> set = dislikeMap.get(cur);
            if (colors[cur - 1] == 0) {
                colors[cur - 1] = target;
            } else if (colors[cur - 1] != target) {
                result = false;
            }
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                int nextTarget = target == 1 ? 2 : 1;
                dfs(dislikeMap, colors, nextTarget, (Integer) iterator.next());
            }
        } else {
            if (colors[cur - 1] == 0) {
                colors[cur - 1] = target;
            } else if (colors[cur - 1] != target) {
                result = false;
            }
        }
    }

    public static void main(String[] args) {
       int[][] dislikes = new int[][] {{1,2},{1,3},{2,4}};
       possibleBipartition(4, dislikes);
    }
}
