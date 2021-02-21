package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode980 {

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int count;

    public int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int uniquePathsIII(int[][] grid) {
        int target = 0;
        int startx = 0;
        int starty = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    target++;
                }
                if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                }
            }
        }
        List<Location> locations = new ArrayList<>();
        dfs(grid, startx, starty, locations, target + 1);
        return count;
    }

    public List<Location> dfs(int[][] grid, int x, int y, List<Location> locations, int target) {
        if (grid[x][y] == 2) {
            if (locations.size() == target) {
                count++;
            }
            return locations;
        }
        Location location = new Location(x, y);
        locations.add(location);
        grid[x][y] = -1;
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != -1) {
                dfs(grid, nx, ny, locations, target);
            }
        }
        grid[x][y] = 0;
        locations.remove(locations.size() - 1);
        return locations;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };
        System.out.println(new LeetCode980().uniquePathsIII(grid));
    }
}
