package com.huawei.leetcode.leetcode41_50;

import java.util.Scanner;

public class LeetCode48 {
    /*
    public static void rotate(int[][] matrix) {
        int add = 0;
        int temp = 0;
        int pos1 = 0;
        int pos2 = matrix[0].length - 1;
        while (pos1 < pos2) {
            add = 0;
            while (add < pos2 - pos1) {
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add];
                matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;

        }
    }
    */

    public static void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        int i = 0, j = 0, length = matrix.length - 1;
        for (i = 0; i < matrix.length; i++) {
            for(j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[length - j][i];
            }
        }
        matrix = newMatrix;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            rotate(matrix);
        }
    }
}
