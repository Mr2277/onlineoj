package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode21_30;

import java.util.Scanner;

public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                length --;
            } else {
                nums[j++] = nums[i + 1];
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
            int length = removeDuplicates(nums);
            for (int j = 0; j < length; j++) {
                System.out.println(nums[j]);
            }
        }
    }
}
