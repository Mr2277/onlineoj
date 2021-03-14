package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode51_60;

public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        int start = 1;
        int direction = 1;
        int i = 0;
        int j = 0;
        while (start <= n * n) {
            switch (direction) {
                case 1 :
                    while (j < n) {
                        if (grid[i][j] != 0) {
                            break;
                        } else {
                            grid[i][j] = start++;
                        }
                        j++;
                    }
                    direction = 2;
                    i = i + 1;
                    j = j - 1;
                    break;
                case 2 :
                    while (i < n) {
                        if (grid[i][j] != 0) {
                            break;
                        } else {
                            grid[i][j] = start++;
                        }
                        i++;
                    }
                    direction = 3;
                    i = i - 1;
                    j = j - 1;
                    break;
                case 3 :
                    while (j >= 0) {
                        if (grid[i][j] != 0) {
                            break;
                        } else {
                            grid[i][j] = start++;
                        }
                        j--;
                    }
                    j = j + 1;
                    i = i - 1;
                    direction = 4;
                    break;
                case 4 :
                    while (i >= 0) {
                        if (grid[i][j] != 0) {
                            break;
                        } else {
                            grid[i][j] = start++;
                        }
                        i--;
                    }
                    i = i + 1;
                    j = j + 1;
                    direction = 1;
                    break;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] grid = leetCode59.generateMatrix(3);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
