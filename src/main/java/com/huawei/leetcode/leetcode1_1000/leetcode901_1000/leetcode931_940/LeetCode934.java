package com.huawei.leetcode.leetcode1_1000.leetcode901_1000.leetcode931_940;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode934 {

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
    public int shortestBridge(int[][] A) {
        int groudId = -1;
        boolean isSearch = false;
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    Location start = new Location(i, j, 0, null);
                    if (!isSearch) {
                        bfs(A, start, groudId);
                        isSearch = true;
                    }
                    else {
                        findShortestBridge(A, i, j, dir, true);
                    }
                }
            }

        }
        return 0;
    }

    public void bfs(int[][] A, Location start, int groupId) {
        Queue<Location> queue = new LinkedList<>();
        List<Location> locations = new ArrayList<>();
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        queue.add(start);
        locations.add(start);
        A[start.x][start.y] = groupId;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < A[0].length && A[nextX][nextY] == 1) {
                        A[nextX][nextY] = groupId;
                        Location next = new Location(nextX, nextY, 0, cur);
                        queue.add(next);
                    }
                }
            }
        }
    }

    public int findShortestBridge(int[][] A, int x, int y, int[][] dir, boolean start) {
        return 0;
    }

    public void printf(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /*
        int[][] A = new int[][] {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        */
        int[][] A = new int[][] {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };
        new LeetCode934().shortestBridge(A);

    }
}
