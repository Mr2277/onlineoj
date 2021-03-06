package com.huawei.leetcode.leetcode1_1000.leetcode601_700.leetcode621_630;

import java.util.Arrays;

public class LeetCode628 {

    public int maximumProduct(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int index = nums.length - 1;
        if (nums[0] >= 0 || nums[index] <= 0) {
            return nums[index] * nums[index - 1] * nums[index - 2];
        } else {
            if (nums[0] * nums[1] > 0) {
                int sum1 = nums[0] * nums[1] * nums[index];
                int sum2 = nums[index] * nums[index - 1] * nums[index - 2];
                return Integer.max(sum1, sum2);
            } else {
                return nums[index] * nums[index - 1] * nums[index - 2];
            }
        }
    }

    public static void main(String[] args) {
        LeetCode628 leetCode628 = new LeetCode628();
        int[] nums = new int[] {-4, 0, 1, 3, 6};
        System.out.println(leetCode628.maximumProduct(nums));
    }
}
