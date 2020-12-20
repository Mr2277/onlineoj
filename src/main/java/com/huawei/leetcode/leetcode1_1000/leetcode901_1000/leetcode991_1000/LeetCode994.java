package com.huawei.leetcode.leetcode1_1000.leetcode901_1000.leetcode991_1000;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode994 {

    static class Location {
        int x;
        int y;
        int step;
        Location from;
        Location(int x, int y, int step, Location from) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.from = from;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0;i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    Location start = new Location(i, j, 0, null);
                    queue.add(start);
                    grid[i][j] = -1;
                }
            }
        }
        int step = bfs(grid, queue);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    step = -1;
                }
            }
        }
        return step;
    }

    public int bfs(int[][] grid, Queue<Location> queue) {
        int max = 0;
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = -1;
                        Location next = new Location(nextX, nextY, cur.step + 1, cur);
                        queue.add(next);
                        max = next.step > max ? next.step : max;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        new LeetCode994().orangesRotting(grid);
    }
}
