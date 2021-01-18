package com.huawei.kexin.leetcodebfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode934 {

    static class Location {
        int x;
        int y;
        int step;
        Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int shortestBridge(int[][] A) {
        int target = 2;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    Queue<Location> queue = findLand(A, i, j, target);
                    target++;
                    result = bfs(queue, A, target);
                    return result;
                }
            }
        }
        return result;
    }

    public Queue<Location> findLand(int[][] A, int x, int y, int target) {
        Location location = new Location(x, y, 0);
        Queue<Location> queue = new LinkedList<>();
        Queue<Location> result = new LinkedList<>();
        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue.add(location);
        result.add(location);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                A[cur.x][cur.y] = target;
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < A[0].length && A[nextX][nextY] == 1) {
                        A[nextX][nextY] = target;
                        Location next = new Location(nextX, nextY, cur.step + 1);
                        queue.add(next);
                        result.add(next);
                    }
                }
            }
        }
        return result;
    }

    public int bfs(Queue<Location> queue, int[][] A, int target) {
        int count = 0;
        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean isFinish = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Location cur = queue.poll();
                for (int[] d : dir) {
                    int nextX = cur.x + d[0];
                    int nextY = cur.y + d[1];
                    if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < A[0].length) {
                        if (A[nextX][nextY] == 0) {
                            A[nextX][nextY] = target;
                            Location next = new Location(nextX, nextY, cur.step + 1);
                            queue.add(next);
                        }
                        if (A[nextX][nextY] == 1) {
                            isFinish = true;
                            count = cur.step;
                            break;
                        }
                    }
                }
                if (isFinish) {
                    queue.clear();
                    break;
                }
            }
        }
        return count;
    }

    public void printf(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();


        }
        System.out.println();
        System.out.println();

    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(new LeetCode934().shortestBridge(A));
    }
}
