package com.huawei.kexin.leetcodebfs;

import javax.xml.namespace.QName;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200 {

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                    //printf(grid);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        Location location = new Location(x, y);
        queue.add(location);
        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                grid[x][y] = '2';
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >=0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY] == '1') {
                        grid[nextX][nextY] = '2';
                        Location next = new Location(nextX, nextY);
                        queue.add(next);
                    }
                }
            }
        }

    }

    public void printf(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        new LeetCode200().numIslands(grid);
    }
}
