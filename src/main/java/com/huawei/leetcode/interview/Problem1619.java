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
    /*
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
    */

    public static int[] pondSizes(int[][] land) {
        List<List<Location>> paths = new ArrayList<>();
        List<Location> path = new ArrayList<>();
        Set<String> alreadySearchSet = new HashSet<>();
        List<List<Location>> copyPaths = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    List<Location> list = new ArrayList<>();
                    DFS(paths, path, land, i, j);
                    for (List<Location> locations : paths) {
                        for (Location location : locations) {
                            //System.out.print(location.x + "#" + location.y + " ");
                            String key = "x:" + String.valueOf(location.x) + " y:" + String.valueOf(location.y);
                            if (!alreadySearchSet.contains(key)) {
                                list.add(location);
                                alreadySearchSet.add(key);
                            }
                        }
                    }
                    copyPaths.add(list);

                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (List<Location> locations : copyPaths) {
            /*
            for (Location location : locations) {
                System.out.print(location.x + "#" + location.y + " ");
            }
            System.out.println();
            */
            result.add(locations.size());
        }
        int[] arr1 = result.stream().sorted().mapToInt(Integer::intValue).toArray();
        return arr1;
    }

    public static List<List<Location>> DFS(List<List<Location>> paths, List<Location> path, int[][] land, int x, int y) {
        int rows = land.length;
        int cols = land[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || land[x][y] != 0) {
            return null;
        }
        Location location = new Location(x, y);
        path.add(location);
        land[x][y] = -1;
        List<List<Location>> up = DFS(paths, path, land,x - 1 ,y);
        List<List<Location>> rightUp = DFS(paths, path, land,x - 1, y + 1);
        List<List<Location>> right = DFS(paths, path, land, x, y + 1);
        List<List<Location>> rightDown = DFS(paths, path, land,x + 1, y + 1);
        List<List<Location>> down = DFS(paths, path, land,x + 1, y);
        List<List<Location>> leftDown = DFS(paths, path, land,x + 1, y - 1);
        List<List<Location>> left= DFS(paths, path, land, x, y - 1);
        List<List<Location>> leftUp = DFS(paths, path, land,x - 1, y - 1);
        if (up == null && rightUp == null && right == null && rightDown == null && down == null && leftDown == null && left == null && leftUp == null) {
            List<Location> copyPath = new ArrayList<>(path);
            paths.add(copyPath);
        } else {

        }
        path.remove(path.size() - 1);
        return paths;
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
