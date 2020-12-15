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
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {

                }
            }
        }
    }

    public List<Location> bfs(int[][] A, Location start, int groupId) {
        Queue<Location> queue = new LinkedList<>();
        List<Location> locations = new ArrayList<>();
        queue.add(start);
        locations.add(start);
        A[start.x][start.y] = groupId;
        while (!queue.isEmpty()) {

        }
    }
    public static void main(String[] args) {
        int[][] A = new int[][] {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
    }
}
