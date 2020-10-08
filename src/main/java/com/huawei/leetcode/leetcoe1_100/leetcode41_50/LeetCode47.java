package com.huawei.leetcode.leetcoe1_100.leetcode41_50;

import java.util.*;

public class LeetCode47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int[] flag = new int[nums.length];
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalResult = new ArrayList<>(DFS(nums, flag, list, result));
        return finalResult;
    }


    public static Set<List<Integer>> DFS(int[] nums, int[] flag, List<Integer> list, Set<List<Integer>> result) {

        if (list.size() == nums.length) {
            List<Integer> subResult = new ArrayList<>(list);
            result.add(subResult);
            return result;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == 0)) {
                    continue;
                }
                if (flag[i] == 0) {
                    flag[i] = 1;
                    list.add(nums[i]);
                    DFS(nums, flag, list, result);
                    flag[i] = 0;
                    list.remove(list.size() - 1);
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            permuteUnique(nums);
        }
    }
}
