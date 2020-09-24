package com.huawei.leetcode.leetcode51_60;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int direction = 0, length = rowNum * colNum, count = 0, i = 0, j = 0, level = 0;
        while (count < length) {
            if (direction == 0) {
                if (j < colNum - level) {
                    result.add(matrix[i][j]);
                    j++;
                } else {
                    j = colNum - level - 1;
                    direction = 1;
                    i++;
                }
                count = result.size();
            } else if (direction == 1) {
                if (i < rowNum - level) {
                    result.add(matrix[i][j]);
                    i++;
                } else {
                    i = rowNum - level - 1;
                    direction = 2;
                    j--;
                }
                count = result.size();
            } else if (direction == 2) {
                if (j >= level) {
                    result.add(matrix[i][j]);
                    j--;
                } else {
                    j = level;
                    direction = 3;
                    i--;
                }
                count = result.size();
            } else if (direction == 3) {
                if (i > level) {
                    result.add(matrix[i][j]);
                    i--;
                } else {
                    direction = 0;
                    level++;
                    i = level;
                    j++;
                }
                count = result.size();
            }
        }
        System.out.println(result.size());
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            spiralOrder(matrix);
        }
    }
}
