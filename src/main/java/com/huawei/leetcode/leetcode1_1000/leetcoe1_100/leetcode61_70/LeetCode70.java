package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode61_70;

public class LeetCode70 {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];


    }


    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs(3));
    }
}
