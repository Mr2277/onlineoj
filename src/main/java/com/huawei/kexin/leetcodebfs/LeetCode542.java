package com.huawei.kexin.leetcodebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode542 {

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    grid[i][j] = 0;
                    matrix[i][j] = -1;
                    Location location = new Location(i ,j);
                    queue.add(location);
                }
            }
        }
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[nextX][nextY] != -1) {
                        matrix[nextX][nextY] = -1;
                        grid[nextX][nextY] = grid[cur.x][cur.y] + 1;
                        Location next = new Location(nextX, nextY);
                        queue.add(next);
                    }
                }
            }
        }
        return grid;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
        matrix = new LeetCode542().updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
