package com.huawei.leetcode.leetcoe1_100.leetcode51_60;

import java.util.Scanner;

public class LeetCode55 {

    public static boolean canJump(int[] nums) {
        boolean result = false;
        int index = 0, stepSize, reachIndex, maxStep, nextStepSize, nextIndex;
        while (index < nums.length) {
            stepSize = nums[index];
            reachIndex = index + stepSize;
            maxStep = Integer.MIN_VALUE;
            if (reachIndex < nums.length - 1 && stepSize == 0) {
                break;
            }
            if (reachIndex >= nums.length - 1) {
                result = true;
                break;
            } else {
                nextIndex = index;
                for (int i = index + 1; i <= index + stepSize; i++) {
                    nextStepSize = nums[i];
                    if (nextStepSize + i > maxStep) {
                        maxStep = nextStepSize + i;
                        nextIndex = i;
                    }
                }
                index = nextIndex;
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
            System.out.println(canJump(nums));
        }
    }
}
