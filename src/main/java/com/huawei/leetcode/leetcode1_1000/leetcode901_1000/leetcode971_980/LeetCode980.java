package com.huawei.leetcode.leetcode1_1000.leetcode901_1000.leetcode971_980;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode980 {
    /*
    public static int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int x = 0;
        int y = 0;
        Set<String> locationSet = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    locationSet.add(i + "@" + j);
                }
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        DFS(path, paths, x, y, grid);
        paths = paths.stream().filter(element -> element.size() == locationSet.size() + 2).collect(Collectors.toList());

        return paths.size();
    }
    */
    /*
    public static List<List<String>> DFS(List<String> path, List<List<String>> paths, int x, int y, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == -1) {
            return paths;
        }
        if (grid[x][y] == 2) {
            List<String> copyPah = new ArrayList<>(path);
            copyPah.add(x + "@" + y);
            paths.add(copyPah);
            return paths;
        }
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            path.add(x + "@" + y);
            grid[x][y] = -1;
            DFS(path, paths, nextX, nextY, grid);
            grid[x][y] = 0;
            path.remove(path.size() - 1);
        }
        return paths;
    }
    */

    public static int uniquePathsIII(int[][] grid) {
        int x = 0;
        int y = 0;
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    step++;
                }
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return DFS(step + 1, x, y, grid);
    }

    public static int DFS(int cur, int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return cur == 0 ? 1 : 0;
        }
        int res = 0;
        grid[x][y] = -1;
        int[][] dir = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1,0}};
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            res += DFS(cur - 1, nextX, nextY, grid);
        }
        grid[x][y] = 0;
        return res;
    }

    public static void main(String[] args) {
        int[][] grip = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(uniquePathsIII(grip));
    }
}
