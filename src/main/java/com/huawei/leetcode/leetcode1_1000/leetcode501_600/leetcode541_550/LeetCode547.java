package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode541_550;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LeetCode547 {

    public static Set<Integer> alreadySearchSet = new HashSet<>();

    public static int findCircleNum(int[][] M) {
        int rows = M.length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            Integer key = i;
            if (!alreadySearchSet.contains(key)) {
                alreadySearchSet.add(key);
                DFS(M, i);
                sum ++;
            }
        }
        return sum;
    }

    public static void DFS(int[][] M, int i) {
        for (int k = 0; k < M.length; k++) {
            if (i != k && M[i][k] == 1) {
                if (!alreadySearchSet.contains(k)) {
                    alreadySearchSet.add(k);
                    DFS(M, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] M = new int[n][n];
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    M[i][j] = scanner.nextInt();
                }
            }
            System.out.println(findCircleNum(M));
        }
    }
}
