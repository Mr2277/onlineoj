package com.huawei.leetcode.leetcode41_50;

import java.util.Scanner;

public class LeetCode45 {
    public static int jump(int[] nums) {
        int index = 0, steps = 0, maxStep, maxStepIndex, curStep;
        if (nums.length == 1) {
            return 0;
        }
        while (true) {
            curStep = nums[index];
            steps ++;
            if (curStep + index >= nums.length - 1) {
                break;
            } else {
                maxStep = Integer.MIN_VALUE;
                maxStepIndex = Integer.MIN_VALUE;
                for (int i = index + 1; i <= index + curStep; i++) {
                    if (i < nums.length && i + nums[i] > maxStep) {
                        maxStep = i + nums[i];
                        maxStepIndex = i;
                    }
                }
                index = maxStepIndex;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            jump(nums);
        }
    }
}
