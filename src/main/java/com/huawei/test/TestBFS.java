package com.huawei.test;

import java.util.LinkedList;
import java.util.Queue;

public class TestBFS {
    static class Location {
        int x;
        int y;
        Location from;
        Location(int x, int y, Location from) {
            this.x = x;
            this.y = y;
            this.from = from;
        }
    }

    public void bfs(int[][] grid) {
        Queue<Location> queue = new LinkedList<>();
        int[][] dir = new int[][] {{0, -1}, {0, -1}, {0, 1}, {1, 0}};
        Location location = new Location(0, 0, null);
        queue.add(location);
        grid[0][0] = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == 0) {
                        grid[nextX][nextY] = -1;
                        Location next = new Location(nextX, nextY, cur);
                        queue.add(next);
                        if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                            /*
                            for (int m = 0; m < grid.length; m++) {
                                for (int n = 0; n < grid[0].length; n++) {
                                    System.out.print(grid[m][n] + " ");
                                }
                                System.out.println();
                            }
                            */



                            Location temp = next;
                            while (temp != null) {
                                System.out.println(temp.x + " " + temp.y);
                                temp = temp.from;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
        };
        new TestBFS().bfs(grid);
    }
}
