package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode541_550;

import java.util.*;

public class LeetCode542 {
    /*
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    String key = String.valueOf(i) + String.valueOf(j);
                    locationMap.put(key, 9999);
                    int result = findZero(matrix,0, i, j, key);
                    matrix[i][j] = result;
                    locationMap.put(String.valueOf(i) + String.valueOf(j), result);
                } else {
                    locationMap.put(String.valueOf(i) + String.valueOf(j), 0);
                }
            }
        }
        return matrix;
    }

    public static Map<String, Integer> locationMap = new HashMap<>();

    public static int findZero(int[][] matrix, int depth, int x, int y, String key) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (x < 0 || x == rows || y < 0 || y == cols || matrix[x][y] == -1) {
            return 9999;
        }
        if (matrix[x][y] == 0) {
            return 0;
        }
        int origin = matrix[x][y];
        if (locationMap.containsKey(key)) {
            if (depth >= locationMap.get(key)) {
                return depth;
            }
        }
        if (Integer.parseInt(key) > 10 * x + y) {
            return locationMap.get(String.valueOf(x) + String.valueOf(y));
        }
        matrix[x][y] = -1;
        int up = findZero(matrix,depth + 1,x - 1, y, key) + 1;
        if (key.equals(String.valueOf(x) + String.valueOf(y))) {
            locationMap.put(key, Integer.min(up, locationMap.get(key)));
        }
        int down = findZero(matrix, depth + 1,x + 1, y, key) + 1;
        if (key.equals(String.valueOf(x) + String.valueOf(y))) {
            locationMap.put(key, Integer.min(down, locationMap.get(key)));
        }
        int left = findZero(matrix, depth + 1, x, y - 1, key) + 1;
        if (key.equals(String.valueOf(x) + String.valueOf(y))) {
            locationMap.put(key, Integer.min(left, locationMap.get(key)));
        }
        int right = findZero(matrix, depth + 1, x, y + 1, key) + 1;
        if (key.equals(String.valueOf(x) + String.valueOf(y))) {
            locationMap.put(key, Integer.min(right, locationMap.get(key)));
        }
        matrix[x][y] = origin;
        int result = Integer.min(up, down);
        result = Integer.min(result, left);
        result = Integer.min(result, right);
        return result;
    }
    */
    /*
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    //BFS(matrix, i, j);
                    String element = i + "@" + j + "@" + 0;
                    queue.add(element);
                }
            }
        }
        BFS(matrix, queue);
        return matrix;
    }

    public static void BFS(int[][] matrix, Queue<String> queue) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] flag = new boolean[rows][cols];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String[] curElements = queue.poll().split("@");
                int curX = Integer.parseInt(curElements[0]);
                int curY = Integer.parseInt(curElements[1]);
                int step = Integer.parseInt(curElements[2]);
                flag[curX][curY] = true;
                int xx = curX - 1;
                int yy = curY;
                String element = "";
                if (isAdd(xx, yy, matrix)) {
                    if (!flag[xx][yy] || matrix[xx][yy] > step + 1) {
                        matrix[xx][yy] = step + 1;
                        element = xx + "@" + yy + "@" + (step + 1);
                        queue.add(element);
                    }
                }
                xx = curX;
                yy = curY + 1;
                if (isAdd(xx, yy, matrix)) {
                    if (!flag[xx][yy] || matrix[xx][yy] > step + 1) {
                        matrix[xx][yy] = step + 1;
                        element = xx + "@" + yy + "@" + (step + 1);
                        queue.add(element);
                    }
                }
                xx = curX + 1;
                yy = curY;
                if (isAdd(xx, yy, matrix)) {
                    if (!flag[xx][yy] || matrix[xx][yy] > step + 1) {
                        matrix[xx][yy] = step + 1;
                        element = xx + "@" + yy + "@" + (step + 1);
                        queue.add(element);
                    }
                }
                xx = curX;
                yy = curY - 1;
                if (isAdd(xx, yy, matrix)) {
                    if (!flag[xx][yy] || matrix[xx][yy] > step + 1) {
                        matrix[xx][yy] = step + 1;
                        element = xx + "@" + yy + "@" + (step + 1);
                        queue.add(element);
                    }
                }
            }
        }
    }

    public static boolean isAdd(int x, int y, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return true;
        }
        return false;
    }
   /*
    public static int BFS(int[][] matrix, int x, int y) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<String> queue = new LinkedList<>();
        queue.add(String.valueOf(x) + "@" + String.valueOf(y));
        int step = 0, curSize = 1, lastSize = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curSize; i++) {
                String[] location = queue.poll().split("@");
                int curX = Integer.parseInt(location[0]) - 1;
                int curY = Integer.parseInt(location[1]);
                if (curX >= 0 && curX < rows && curY >=0 && curY < cols) {
                    if (matrix[curX][curY] != 0) {
                        queue.add(String.valueOf(curX) + "@" + String.valueOf(curY));
                    } else {
                        queue.clear();
                        break;
                    }
                }
                curX = Integer.parseInt(location[0]);
                curY = Integer.parseInt(location[1]) + 1;
                if (curX >= 0 && curX < rows && curY >=0 && curY < cols) {
                    if (matrix[curX][curY] != 0) {
                        queue.add(String.valueOf(curX) + "@" + String.valueOf(curY));
                    } else {
                        queue.clear();
                        break;
                    }
                }
                curX = Integer.parseInt(location[0]) + 1;
                curY = Integer.parseInt(location[1]);
                if (curX >= 0 && curX < rows && curY >=0 && curY < cols) {
                    if (matrix[curX][curY] != 0) {
                        queue.add(String.valueOf(curX) + "@" + String.valueOf(curY));
                    } else {
                        queue.clear();
                        break;
                    }
                }
                curX = Integer.parseInt(location[0]);
                curY = Integer.parseInt(location[1]) - 1;
                if (curX >= 0 && curX < rows && curY >=0 && curY < cols) {
                    if (matrix[curX][curY] != 0) {
                        queue.add(String.valueOf(curX) + "@" + String.valueOf(curY));
                    } else {
                        queue.clear();
                        break;
                    }
                }

            }
            step++;

        }
        return step;
    }
    */
    public static int[][] updateMatrix(int[][] matrix) {
        int[][] res;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        res=new int[matrix.length][matrix[0].length];
        LinkedList<int[]> queue=new LinkedList<>();
        LinkedList<int[]> queue1 = new LinkedList<>();
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==0)//将0元素入队
                {
                    res[i][j]=0;
                    matrix[i][j]=-1;

                }
        while (!queue.isEmpty())
        {
            int[] p=queue.removeFirst();
            int x=p[0],y=p[1];
            for(int[] d:dir)//4个方向入队
            {
                int nextX=x+d[0],nextY=y+d[1];
                if(nextX<0||nextY<0||nextX>=matrix.length||nextY>=matrix[0].length||matrix[nextX][nextY]==-1)//不符合的情况剔除
                    continue;
                res[nextX][nextY]=res[x][y]+1;
                matrix[nextX][nextY]=-1;
                queue.add(new int[]{nextX,nextY});
            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[][] map = new int[][] {
                {0, 1, 0, 1},
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        updateMatrix(map);
    }
}
