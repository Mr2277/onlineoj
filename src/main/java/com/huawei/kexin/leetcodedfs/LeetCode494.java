package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            int res = 0;
            if (nums[0] == S) {
                res++;
            }
            if (nums[0] == 0 - S) {
                res++;
            }
            return res;
        }
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
            dfs(num, flag, sub, lists);
            lists = lists.stream().distinct().collect(Collectors.toList());
        }
        int count = 0;
        for (List<Integer> list : lists) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = list.get(i) == 1 ? sum + nums[i] : sum - nums[i];
            }
            if (sum == S) {
                count++;
            }
        }
        return count;
    }


    public List<List<Integer>> dfs(int[] num, boolean[] flag, List<Integer> sub, List<List<Integer>> lists) {
        if (sub.size() == num.length) {
            List<Integer> copy = new ArrayList<>(sub);
            lists.add(copy);
            return lists;
        }
        for (int i = 0; i < num.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                sub.add(num[i]);
                dfs(num, flag, sub, lists);
                flag[i] = false;
                sub.remove(sub.size() - 1);
            }
        }
        return lists;
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
