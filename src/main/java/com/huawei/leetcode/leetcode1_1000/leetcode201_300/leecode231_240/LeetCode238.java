package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leecode231_240;

public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul = mul * nums[i];
        }
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                array[i] = mul / nums[i];
            } else {
                int result = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        result = result * nums[j];
                    }
                }
                array[i] = result;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {1, 2, 3, 4};
        int[] nums = new int[] {0 ,0};
        int[] array = new LeetCode238().productExceptSelf(nums);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
