package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode211_220;

public class LeetCode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1, 2, 3};
        LeetCode219 leetCode219 = new LeetCode219();
        System.out.println(leetCode219.containsNearbyDuplicate(nums, 2));
    }
}
