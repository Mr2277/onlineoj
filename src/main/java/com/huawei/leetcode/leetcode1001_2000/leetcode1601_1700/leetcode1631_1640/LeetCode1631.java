package com.huawei.leetcode.leetcode1001_2000.leetcode1601_1700.leetcode1631_1640;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1631 {

    public static int minimumEffortPath(int[][] heights) {
        if (heights.length == 1) {
            return 0;
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        paths = dfs(heights, 0, 0, path, paths);
        int result = Integer.MAX_VALUE;
        for (List<Integer> list : paths) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                int sub = Math.abs(list.get(i + 1) - list.get(i));
                max = sub > max ? sub : max;
            }
            result = result > max ? max : result;
        }
        return result;
    }

    public static List<List<Integer>> dfs(int[][] heights, int x, int y, List<Integer> path, List<List<Integer>> paths) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || heights[x][y] == -1) {
            return paths;
        }
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(heights[x][y]);
            paths.add(copyPath);
            return paths;
        }
        path.add(heights[x][y]);
        int temp = heights[x][y];
        heights[x][y] = -1;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            dfs(heights, nextX, nextY, path, paths);
        }
        heights[x][y] = temp;
        path.remove(path.size() - 1);
        return paths;
    }
    public static void main(String[] args) {
        int[][] heights = new int[][] {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(minimumEffortPath(heights));
    }
}
