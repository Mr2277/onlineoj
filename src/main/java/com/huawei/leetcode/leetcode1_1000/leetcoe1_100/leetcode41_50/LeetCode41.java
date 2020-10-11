package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode41_50;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode41 {
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        } else {
            Arrays.sort(nums);
            int result = 1, num = nums[nums.length - 1];
            if (nums[0] > 1) {
                return result;
            } else if (num < 1) {
                return result;
            } else {
                int diff = 0, i;
                for (i = 0; i < nums.length - 1; i++) {
                    if (nums[i] < 0) {
                        diff = nums[i + 1] - 0;
                    } else {
                        diff = nums[i + 1] - nums[i];
                    }
                    if (diff > 1) {
                        if (nums[i] < 0) {
                            result = 1;
                        } else {
                            result = nums[i] + 1;
                        }
                        break;
                    }
                }
                if (i == nums.length - 1) {
                    result = nums[nums.length - 1] + 1;
                }
                return result;
            }
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
            System.out.println(firstMissingPositive(nums));
        }
    }
}
