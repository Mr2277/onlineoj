package com.huawei.kexin.leetcodebfs;

import java.util.*;

public class LeetCode64 {

    static class Location {
        int x;
        int y;
        int sum;
        Location(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public int minPathSum(int[][] grid) {
        if (0 == grid.length - 1 && 0 == grid[0].length - 1) {
            return grid[0][0];
        }
        Set<String> searched = new HashSet<>();
        Queue<Location> queue = new LinkedList<>();
        Location start = new Location(0, 0, grid[0][0]);
        queue.add(start);
        List<Location> locations = new ArrayList<>();
        int[][] dir = new int[][] {{1, 0}, {0, 1}};
        int resutl = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = d[0] + cur.x;
                    int nextY = d[1] + cur.y;
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                        Location next = new Location(nextX, nextY, cur.sum + grid[nextX][nextY]);
                        if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                            resutl = next.sum < resutl ? next.sum : resutl;
                        }
                        String key = nextX + "@" + nextY + "@" + next.sum;
                        if (!searched.contains(key)) {
                            queue.add(next);
                            searched.add(key);
                        }
                    }
                }
            }
        }
        //int min = locations.stream().map(location -> location.sum).min(Integer::compareTo).get();
        //System.out.println();
        return resutl;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new LeetCode64().minPathSum(grid));
    }
}
