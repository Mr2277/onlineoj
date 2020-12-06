package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode201_210;

import java.util.*;

public class LeetCode210 {
    /*
    public boolean isHas = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            set.add(i);
        }
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                set.remove(pre[0]);
                map.put(pre[1], list);
            } else {
                List<Integer> list = map.get(pre[1]);
                list.add(pre[0]);
                set.remove(pre[0]);
                map.put(pre[1], list);
            }
        }
        boolean[] flag = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (Integer key : set) {
            queue.add(key);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer integer = queue.poll();
                    if (flag[integer]) {
                        isHas = false;
                    } else {
                        flag[integer] = true;
                        result.add(integer);
                        if (map.containsKey(integer)) {
                            for (Integer integer1 : map.get(integer)) {
                                queue.add(integer1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result.size());
        return new int[numCourses];
    }
    */
    public int[] findOrder(int num, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] flag = new boolean[num];
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                flag[pre[0]] = true;
                map.put(pre[1], list);
            } else {
                List<Integer> list = map.get(pre[1]);
                list.add(pre[0]);
                flag[pre[0]] = true;
                map.put(pre[1], list);
            }
        }
        int cur = 0;
        for (int i = 0; i < num; i++) {
            if (!flag[i]) {
                cur = i;
            }
        }
        int[] colors = new int[num];
        dfs(map, colors, cur);
        return new int[] {};
    }
    public static boolean isXunHuan = false;
    public static List<Integer> list = new ArrayList<>();
    public static void dfs(Map<Integer, List<Integer>> map, int[] colors, int cur) {
        if (colors[cur] == 0) {
            colors[cur] = -1;
            if (map.containsKey(cur)) {
                List<Integer> list = map.get(cur);
                for (Integer integer : list) {
                    dfs(map, colors, integer);
                }
            }
            colors[cur] = 1;
        }
        if (colors[cur] == -1) {
            isXunHuan = true;
        }
    }
    public static void main(String[] args) {
        int[][] pre = new int[][] {{1,0},{2,0},{3,1},{3,2},{2,3}};
        new LeetCode210().findOrder(4, pre);
    }
}
