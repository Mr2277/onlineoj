package com.huawei.kexin.leetcodedfs;

public class LeetCode542 {

    public int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    tx = i;
                    ty = j;
                    res[i][j] = dfs(matrix, i ,j, flag, 0);
                    minStep = Integer.MAX_VALUE;
                }
            }
        }
        return res;
    }

    public int minStep = Integer.MAX_VALUE;

    public int tx;

    public int ty;

    public int dfs(int[][] matrix, int x, int y, boolean[][] flag, int step) {
        int sum = 999999;
        if (step > minStep) {
            return sum;
        }
        if (x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length && !flag[x][y]) {
            if (matrix[x][y] == 0) {
                minStep = Integer.min(step, minStep);
                return 0;
            }
            flag[x][y] = true;
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                int res = dfs(matrix, nx, ny , flag, step + 1) + 1;
                sum = Integer.min(sum, res);
            }
            flag[x][y] = false;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };
        int[][] res = new LeetCode542().updateMatrix(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + "");
            }
            System.out.println();
        }
    }
}
