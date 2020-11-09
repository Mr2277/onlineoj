package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode571_580;

public class LeetCode576 {

    public static int findPaths(int m, int n, int N, int i, int j) {
        return 0;
    }

    public static int DFS(int[][] grid, int x, int y, int step) {
        if (step <= 0 || grid[x][y] == -1) {
            return 0;
        }
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 1;
        }
        int res = 0;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        grid[x][y] = -1;
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            res += DFS(grid, nextX, nextY, step - 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
