package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode71_80;

import java.util.Arrays;

public class LeetCode75 {

    public void sortColors(int[] nums) {
        int[] array = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 0, 2, 1, 1, 0};
        new LeetCode75().sortColors(nums);
        for (Integer integer : nums) {
            System.out.print(integer + " ");
        }
    }
}
