package com.huawei.leetcode.leetcode41_50;

import java.util.*;

public class LeetCode44 {
    /*
    public static int min = Integer.MAX_VALUE;

    public static int jump(int[] nums) {
        DFS(nums, 0, 0);
        System.out.println(min);
        return min;
    }

    public static void DFS(int[] nums, int index, int skipTimes) {
        if (index >= nums.length - 1) {
            if (skipTimes < min) {
                min = skipTimes;
            }
            return ;
        }
        int cur = nums[index];
        for (int i = index + 1; i <= cur + index; i++) {
            DFS(nums, i, skipTimes + 1);
        }
    }
    */

    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(jump(nums));
        }
    }
}
