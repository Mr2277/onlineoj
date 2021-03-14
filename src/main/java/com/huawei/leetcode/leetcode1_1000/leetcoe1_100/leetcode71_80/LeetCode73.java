package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode71_80;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode73 {

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes(int[][] matrix) {
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Location cur = new Location(i, j);
                    queue.add(cur);
                }
            }
        }
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[location.x][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][location.y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode73 leetCode73 = new LeetCode73();
        int[][] matrix = new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        leetCode73.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
