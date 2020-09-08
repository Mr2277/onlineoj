package com.huawei.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode1 {
    /*
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[2];
        //Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (nums[left] + nums[right] > target) {
                right --;
            } else {
                left++;
            }
        }
        return result;
    }
    */

    public static int[] twoSum(int[]nums, int target) {
        int[] flag = new int[nums.length];
        int[] result = new int[2];
        return DFS(nums, flag, result, 0, target, 0);
    }

    public static int[] DFS(int[] nums, int[] flag, int[] result, int sum, int target, int level) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                sum += nums[i];
                flag[i] = 1;
                if (level < 1) {
                   result = DFS(nums, flag, result, sum, target, level + 1);
                }
                if (sum == target && level == 1) {
                    int k = 0;
                    for (int j = 0; j < flag.length; j++) {
                        if (flag[j] == 1) {
                            result[k++] = j;
                        }
                    }
                    return result;
                }

                flag[i] = 0;
                sum -= nums[i];
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
            twoSum(nums, target);
        }
    }
}
