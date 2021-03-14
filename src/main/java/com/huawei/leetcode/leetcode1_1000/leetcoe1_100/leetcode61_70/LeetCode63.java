package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode61_70;

public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfs(obstacleGrid, 0, 0);
    }

    public int[][] dir = new int[][] {{0, 1}, {1, 0}};

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1) {
            return 0;
        }
        if (x == grid.length -1 && y == grid[0].length - 1) {
            return 1;
        }
        int res = 0;
        grid[x][y] = 1;
        for (int[] d : dir) {
            res += dfs(grid, x + d[0], y + d[1]);
        }
        grid[x][y] = 0;
        return res;
    }
    public static void main(String[] args) {
        LeetCode63 leetCode63 = new LeetCode63();
        int[][] grid = new int[][] {
                {0,0,0,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        System.out.println(leetCode63.uniquePathsWithObstacles(grid));
    }
}
