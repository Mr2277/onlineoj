package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode31_40;

import java.util.Scanner;

public class LeetCode35 {

    public static int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        if (index == -1) {
            int i = 0;
            for (i = 0; i < nums.length; i++) {
                if (target < nums[i]) {
                    index = i;
                    break;
                }
            }
            if (i == nums.length) {
                index = nums.length;
            }
        }
        return index;

    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return mid;
        }
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
            searchInsert(nums, target);
        }
    }
}
