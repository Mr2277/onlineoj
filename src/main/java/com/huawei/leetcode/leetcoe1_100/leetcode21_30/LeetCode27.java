package com.huawei.leetcode.leetcoe1_100.leetcode21_30;

import java.util.Scanner;

public class LeetCode27 {

    public static int removeElement(int[] nums, int val) {
        int length = nums.length, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length --;
            } else {
                nums[ans++] = nums[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int val = scanner.nextInt();
            removeElement(nums, val);
        }
    }
}
