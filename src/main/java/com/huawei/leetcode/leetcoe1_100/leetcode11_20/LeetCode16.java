package com.huawei.leetcode.leetcoe1_100.leetcode11_20;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode16 {

    public static int threeSumClosest(int[] nums, int target) {
        int left, right, ans = Integer.MAX_VALUE, flag, sum, result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (result == target) {
                break;
            }
            flag = nums[i];
            left = i + 1;
            right = nums.length - 1;
            if (i < nums.length - 1) {
                while (left < right) {
                    sum = flag + nums[left] + nums[right];
                    int dis = (int) Math.abs(target - sum);
                    if (dis < ans) {
                        ans = dis;
                        result = sum;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }
            } else {
                break;
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
            threeSumClosest(nums, target);
        }
    }
}
