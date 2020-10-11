package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode41_50;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode46 {
    public static List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        return DFS(nums, flag, result, subResult);
    }

    public static List<List<Integer>> DFS(int[] nums, int[] flag, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            List<Integer> suResult = new ArrayList<>(list);
            result.add(suResult);
            return result;
        } else {
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == 0) {
                    flag[i] = 1;
                    list.add(nums[i]);
                    result = DFS(nums, flag, result, list);
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
            permute(nums);
        }
    }
}
