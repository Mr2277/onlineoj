package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode31_40;

import java.util.Scanner;

public class LeetCode34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (target == nums[i]) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            searchRange(nums, target);
        }
    }
}
