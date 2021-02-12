package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode281_290;

import java.util.Arrays;

public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int[] flag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]]++;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] > 1) {
                return i;
            }
        }
        return Arrays.stream(flag).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,1,3,4,2};
        System.out.println(new LeetCode287().findDuplicate(nums));
    }
}
