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

    public boolean result = true;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> dislikesMap = new HashMap<>();
        for (int[] dis : dislikes) {
            if (!dislikesMap.containsKey(dis[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(dis[1]);
                dislikesMap.put(dis[0], list);
            } else {
                List<Integer> list = dislikesMap.get(dis[0]);
                list.add(dis[1]);
                dislikesMap.put(dis[0], list);
            }
        }
        int[] colors = new int[N];
        for (Integer key : dislikesMap.keySet()) {
            int target = 0;
            if (colors[key -1] != 0) {
                target = colors[key - 1];
            }
            for (Integer integer : dislikesMap.get(key)) {
                if (colors[integer - 1] != 0) {
                    int flag = colors[integer - 1] == 1 ? 2 : 1;
                    if (target != 0 && target != flag) {
                        result = false;
                    }
                    if (target == 0) {
                        target = flag;
                    }
                }
            }
            if (colors[key - 1] == 0) {
                dfs(dislikesMap, colors, target, key);
            }
        }
        return result;
    }
    public  void dfs(Map<Integer, List<Integer>> map, int[] colors, int target, int cur) {
        if (colors[cur - 1] == 0) {
            colors[cur - 1] = target;
        } else if (colors[cur - 1] != target) {
            result = false;
        }
        if (map.containsKey(cur)) {
            List<Integer> list = map.get(cur);
            int nextTarget = target == 1 ? 2 : 1;
            for (Integer integer : list) {
                if (colors[integer - 1] == 0) {
                    dfs(map, colors, nextTarget, integer);
                } else if (colors[integer - 1] != nextTarget) {
                    result = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        //int[][] dislikes = new int[][] {{1,2},{2,3},{3,4},{4,5},{1,5}};
        int[][] dislikes = new int[][] {{1,2},{1,3},{2,3}};
        new LeetCode886().possibleBipartition(3, dislikes);
    }
}
