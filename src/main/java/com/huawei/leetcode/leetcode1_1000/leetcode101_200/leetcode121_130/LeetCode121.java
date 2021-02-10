package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode121_130;

public class LeetCode121 {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxMoney = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                left = i;
                max = Integer.MIN_VALUE;
                continue;
            }
            if (prices[i] > max) {
                max = prices[i];
                right = i;
            }
            if (right > left) {
                maxMoney = max - min > maxMoney ? max - min : maxMoney;
            }
        }

        return maxMoney;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2,1,2,1,0,1,2};
        System.out.println(new LeetCode121().maxProfit(prices));
    }
}
