package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dis : dislikes) {
            if (!map.containsKey(dis[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(dis[1]);
                map.put(dis[0], list);
            } else {
                List<Integer> list = map.get(dis[0]);
                list.add(dis[1]);
                map.put(dis[0], list);
            }
            if (!map.containsKey(dis[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(dis[0]);
                map.put(dis[1], list);
            } else {
                List<Integer> list = map.get(dis[1]);
                list.add(dis[0]);
                map.put(dis[1], list);
            }
        }
        int[] flag = new int[N + 1];
        for (Integer key : map.keySet()) {
            int target = 0;
            if (flag[key] != 0) {
                target = flag[key];
            }
            for (Integer integer : map.get(key)) {
                if (flag[integer] != 0) {
                    int flag1 = flag[integer] == 1 ? 2 : 1;
                    if (target != 0 && target != flag1) {
                        return false;
                    }
                    if (target == 0) {
                        target = flag1;
                    }
                }
            }
            if (flag[key] == 0) {
                return dfs(map, key, target, flag);
            }
        }
        return false;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, int index, int terget, int[] flag) {
        flag[index] = -1;
        boolean result = true;
        if (map.containsKey(index)) {
            List<Integer> list = map.get(index);
            int nextTarget = terget == 1 ? 2 : 1;
            for (Integer integer : list) {
                if (flag[integer] == 0) {
                   result = dfs(map, integer, nextTarget, flag);
                } else if (flag[integer] != -1) {
                    if (flag[integer] == terget) {
                        return false;
                    }
                }
            }
        }
        flag[index] = terget;
        return result;
    }

    public static void main(String[] args) {
        int[][] dislikes = new int[][] {{1, 5},{1, 2},{2, 3},{3, 4},{4, 5}};
        System.out.println(new LeetCode886().possibleBipartition(5, dislikes));
    }
}
