package com.huawei.leetcode;

import java.util.Scanner;

public class LeetCode11 {
    public static int maxArea(int[] height) {
        // int[][] dp = new int[height.length][height.length];
        int max = Integer.MIN_VALUE, temp = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] <= height[i]) {
                    temp = height[j] * (j - i);
                } else {
                    temp = height[i] * (j - i);
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < height.length; i++) {
                height[i] = scanner.nextInt();
            }
            System.out.println(maxArea(height));
        }
    }
}
