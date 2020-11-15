package com.huawei.leetcode.leetcode1_1000.leetcode601_700.leetcode691_700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //int curSize = dfs(grid, i, j);
                    int curSize = bfs(grid, i, j);
                    max = max > curSize ? max : curSize;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<String> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        queue.add(x + "@" + y);
        path.add(x + "@" + y);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[][] dir = new int[][] {{-1 ,0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < size; i++) {
                String[] location = queue.poll().split("@");
                int curX = Integer.parseInt(location[0]);
                int curY = Integer.parseInt(location[1]);
                grid[curX][curY] = 0;
                for (int[] d : dir) {
                    int nextX = curX + d[0];
                    int nextY = curY + d[1];
                    if ( nextX >=0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                        queue.add(nextX + "@" + nextY);
                        grid[nextX][nextY] = 0;
                        path.add(nextX + "@" + nextY);
                    }
                }
            }

        }
        return path.size();
    }
    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int res = 1;
        grid[x][y] = 0;
        int[][] dir = new int[][] {{-1 ,0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            res += dfs(grid, nextX, nextY);
        }
        //grid[x][y] = 1;
        return res;
    }

}
