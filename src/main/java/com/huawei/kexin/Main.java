package com.huawei.kexin;

import java.util.Scanner;

public class Main {
    public static void findMaxLength(int[] nums, int target) {
        int left = 0, right = 0, sum = 0, max = Integer.MIN_VALUE, length = 0, start = 0, end = 0;
        while (left < nums.length) {
            sum += nums[right];
            if (sum <= target) {
                length = right - left + 1;
                if (length > max) {
                    max = length;
                    start = left;
                    end = right;
                }
            } else {
                while (sum > target) {
                    sum -= nums[left];
                    left ++;
                }

            }
            right ++;
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
            findMaxLength(nums, target);
        }
    }
}
