package com.huawei.kexin.leetcodebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode542 {

    static class Location {
        int x;
        int y;
        int target;
        Location(int x, int y, int target) {
            this.x = x;
            this.y = y;
            this.target = target;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        Queue<Location> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Location location = new Location(i, j,0);
                    queue.add(location);
                    list.add(i + "@" + j);
                }
            }
        }
        int[][] dir = new int[][] {{0, -1}, {0, -1}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length) {
                        if (!list.contains(nextX + "@" + nextY)) {
                            if (matrix[nextX][nextY] == 0) {
                                matrix[cur.x][cur.y] = 1;
                            } else {
                                matrix[nextX][nextY] = cur.target + 1;
                            }
                            Location next = new Location(nextX, nextY, cur.target + 1);
                            queue.add(next);
                            list.add(nextX + "@" + nextY);
                        }

                    }

                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
        new LeetCode542().updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
