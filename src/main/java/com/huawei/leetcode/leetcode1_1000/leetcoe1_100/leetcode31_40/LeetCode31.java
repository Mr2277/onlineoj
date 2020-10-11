package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode31_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeetCode31 {

    public static void nextPermutation(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIndex = -1, minIndex = -1, i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (subList.isEmpty()) {
                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
                subList.add(nums[i]);
            } else {
                if (nums[i] < max) {
                    break;
                } else {
                    maxIndex = i;
                    max = nums[i];
                    subList.add(nums[i]);
                }
            }
        }
        int temp;
        Collections.sort(subList);
        if (i < 0) {
            for (int m = 0; m < nums.length; m++) {
                nums[m] = subList.get(m);
            }
        } else {
            if (min > nums[i]) {
                temp = nums[i];
                nums[i] = min;
                subList.remove(0);
                subList.add(0, temp);
            } else {
                int k = 0;
                for (k = 0; k < subList.size(); k++) {
                    if (subList.get(k) > nums[i]) {
                        break;
                    }
                }
                temp = nums[i];
                nums[i] = subList.get(k);
                subList.remove(k);
                subList.add(k, temp);
            }
            Collections.sort(subList);
            for (int j = i + 1; j < nums.length; j++) {
                nums[j] = subList.get(j - i - 1);
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
            nextPermutation(nums);
        }
    }
}
