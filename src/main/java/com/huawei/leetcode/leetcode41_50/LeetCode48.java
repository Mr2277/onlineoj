package com.huawei.leetcode.leetcode41_50;

import java.util.Scanner;

public class LeetCode48 {
    public static void rotate(int[][] matrix) {
        //System.out.println(matrix.length);
        int rounds = matrix.length / 2, count = 0, flag = 0, i = 0;
        int[] temp0 = new int[matrix.length];
        int[] temp1 = new int[matrix.length];
        int[] temp2 = new int[matrix.length];
        int[] temp3 = new int[matrix.length];
        int length = matrix.length;
        while (count < rounds) {
            if (flag == 0) {
                temp0[i] = matrix[i][length - 1 - count];
                matrix[i][length - 1 - count] = matrix[count][i];
                i++;
                if (i == length - count) {
                    flag = 1;
                    i = count;
                }
            } else if (flag == 1) {
                temp1[i] = matrix[length - 1 - count][length - 1 - i];
                matrix[length - 1 - count][length - 1 - i] = temp0[i];
                i++;
                if (i == length - count) {
                    flag = 2;
                    i = count;
                }
            }
        }
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
