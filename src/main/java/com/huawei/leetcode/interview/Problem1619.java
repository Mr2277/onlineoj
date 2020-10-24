package com.huawei.leetcode.interview;

import java.util.*;

public class Problem1619 {

    public static Set<Location> alreadySearchSet = new HashSet<>();

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] pondSizes(int[][] land) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int num = DFS(land, i, j, 0);
                    result.add(num);
                }
            }
        }
        int[] arr1 = result.stream().sorted().mapToInt(Integer::intValue).toArray();
        return arr1;
    }

    public static int DFS(int[][] land, int x, int y, int num) {
        int rows = land.length;
        int cols = land[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || land[x][y] != 0) {
            return num;
        }
        land[x][y] = -1;
        int up = DFS(land, x - 1 ,y, num);
        int rihtUp = DFS(land, x - 1, y + 1, num);
        int right = DFS(land, x, y + 1, num);
        int rightDown = DFS(land, x + 1, y + 1, num);
        int down = DFS(land, x + 1, y, num);
        int leftDown = DFS(land, x + 1, y - 1, num);
        int left = DFS(land, x, y - 1, num);
        int leftUp = DFS(land, x - 1, y - 1, num);
        return up + right + down + left + leftDown + leftUp + rightDown + rihtUp + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] land = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    land[i][j] = scanner.nextInt();
                }
            }
            pondSizes(land);
        }
    }
}
