package com.huawei.kexin.leetcodedfs;

import java.util.*;

public class LeetCode547 {

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    list.add(j + 1);
                }
            }
            map.put(i + 1, list);
        }
        int[] flag = new int[isConnected.length + 1];
        int sum = 1;
        for (int i = 1; i < isConnected.length + 1; i++) {
            if (flag[i] == 0) {
                dfs(map, flag, i, sum);
                sum++;
            }

        }
        int max = Arrays.stream(flag).max().getAsInt();
        return max;
    }

    public void dfs(Map<Integer, List<Integer>> map, int[] flag, int index, int sum) {
        flag[index] = sum;
        if (map.containsKey(index)) {
            List<Integer> list = map.get(index);
            for (Integer integer : list) {
                if (flag[integer] == 0) {
                    dfs(map, flag, integer, sum);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][] {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };
        System.out.println(new LeetCode547().findCircleNum(isConnected));
    }

}
