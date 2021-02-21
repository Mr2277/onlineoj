package com.huawei.kexin.array;

import java.util.Arrays;

public class InterView1710 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        nums = Arrays.stream(nums).sorted().toArray();
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sum++;
                if (sum > nums.length / 2) {
                    return nums[i];
                }
            } else {
                sum = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int[] nums = new int[] {3, 2};
        System.out.println(new InterView1710().majorityElement(nums));
    }
}
