package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode61_70;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode64 {

    private int[][] dir = new int[][] {{1, 0}, {0, 1}};

    private List<Integer> result = new ArrayList<>();

    private boolean finash = false;

    public static int count = 0;

    public int minPathSum(int[][] grid) {
        return dfs(grid, 0 , 0);
    }

    public Map<String, Integer> searched = new HashMap<>();

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return -1000;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        String key = x + "@" + y;
        if (searched.containsKey(key)) {
            return searched.get(key);
        } else {
            int down = dfs(grid, x + 1, y) + grid[x][y];
            int right = dfs(grid, x, y + 1) + grid[x][y];
            if (down < 0 || right < 0) {
                searched.put(key, Integer.max(down, right));
                return Integer.max(down, right);
            } else {
                searched.put(key, Integer.min(down, right));
                return Integer.min(down, right);
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        /*
        int[][] grid = new int[][] {
                {1, 3},
                {4, 5}
        };
        */
        System.out.println(new LeetCode64().minPathSum(grid));
        System.out.println(count);
    }
}
