package com.huawei.leetcode.leetcode1001_2000.leetcode1401_1500.leetcode1431_1440;

public class LeetCode1438 {

    public int longestSubarray(int[] nums, int limit) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxSize = Integer.MIN_VALUE;
            int count = 0;
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (count == 0) {
                    max = nums[j];
                    min = nums[j];
                }
                if (Math.abs(nums[j] - max) <= limit && Math.abs(nums[j] - min) <= limit) {
                    count++;
                } else {
                    count = 0;
                    continue;
                }
                if (count != 0) {
                    max = nums[j] > max ? nums[j] : max;
                    min = nums[j] < min ? nums[j] : min;
                }
                maxSize = count > maxSize ? count : maxSize;
            }
            res = res < maxSize ? maxSize : res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,6,7,8,10,6,5,6};
        LeetCode1438 leetCode1438 = new LeetCode1438();
        System.out.println(leetCode1438.longestSubarray(nums, 4));
    }
}
