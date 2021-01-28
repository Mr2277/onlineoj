package com.huawei.kexin.leetcodebfs;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1619 {

    static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(bfs(land, i, j));
                }
            }
        }
        list = list.stream().sorted().collect(Collectors.toList());
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    public int bfs(int[][] land, int x, int y) {
        Location location = new Location(x, y);
        Queue<Location> queue = new LinkedList<>();
        int[][] dir = new int[][] {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        queue.add(location);
        land[x][y] = -1;
        int landSize = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < land.length && nextY >= 0 && nextY < land[0].length && land[nextX][nextY] == 0) {
                        landSize++;
                        Location next = new Location(nextX, nextY);
                        land[nextX][nextY] = -1;
                        queue.add(next);
                    }
                }
            }
        }
        return landSize;
    }

    public static void main(String[] args) {
        int[][] land = new int[][] {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] result = new Problem1619().pondSizes(land);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
;    }
}
