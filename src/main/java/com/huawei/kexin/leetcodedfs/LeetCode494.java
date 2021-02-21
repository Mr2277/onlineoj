package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, S);
    }

    public int dfs(int[] nums, int index, int S, int target) {
        if (index == nums.length) {
            if (S == target) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(nums, index + 1,S - nums[index], target) +
               dfs(nums, index + 1,S + nums[index], target);
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        System.out.println(new LeetCode494().findTargetSumWays(nums, 3));
        /*
        LeetCode494 leetCode494 = new LeetCode494();
        List<List<Integer>> lists = new ArrayList<>();
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j <= i) {
                    num[j] = 1;
                }
            }
            boolean[] flag = new boolean[nums.length];
            List<Integer> sub = new ArrayList<>();
            leetCode494.dfs(num, flag, sub, lists);
            lists = lists.stream().distinct().collect(Collectors.toList());
            System.out.println(lists.size());
            System.out.println(lists.size());
        }
        */
    }
}
