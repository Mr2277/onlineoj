package com.huawei.kexin.leetcodebfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1162 {

    static class Location {
        int x;
        int y;
        int step;
        Location source;
        Location(int x, int y, int step, Location source) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.source = source;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Location location = new Location(i, j, 1, null);
                    queue.add(location);
                }
            }
        }
        return bfs(queue, grid);
    }

    public int bfs(Queue<Location> queue, int[][] grid) {
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int maxDis = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 0) {
                        grid[nextX][nextY] = cur.step + 1;
                        Location source = null;
                        int nextDis = 0;
                        if (cur.source == null) {
                            source = new Location(cur.x, cur.y, 1, null);
                            nextDis = Math.abs(nextX - cur.x) + Math.abs(nextY - cur.y);
                        } else {
                            source = cur.source;
                            nextDis = Math.abs(nextX - cur.source.x) + Math.abs(nextY - cur.source.y);
                        }
                        Location next = new Location(nextX, nextY, cur.step + 1, source);
                        queue.add(next);
                        maxDis = nextDis > maxDis ? nextDis : maxDis;
                    }
                }
            }
        }
        return maxDis;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 1},
                {0 ,0, 0},
                {1, 0, 1}
        };
        System.out.println(new LeetCode1162().maxDistance(grid));
    }
}
