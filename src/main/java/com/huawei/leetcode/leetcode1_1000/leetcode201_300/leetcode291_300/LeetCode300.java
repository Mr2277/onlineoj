package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode291_300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int maxSize = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while (left < nums.length) {
            list.add(nums[left]);
            max = nums[left] > max ? nums[left] : max;
            for (int i = left + 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    list.add(nums[i]);
                    max = nums[i];
                }
            }
            maxSize = list.size() > maxSize ? list.size() : maxSize;
            list.clear();
            left++;
            max = Integer.MIN_VALUE;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,2,3};
        System.out.println(new LeetCode300().lengthOfLIS(nums));
    }
}
