package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode31_40;

import java.util.*;

public class LeetCode40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        int[] flag = new int[candidates.length];
        result = DFS(candidates, flag, target,0 ,list, result);
        List<List<Integer>> finalResult = new ArrayList<>(result);
        return finalResult;
    }

    public static Set<List<Integer>> DFS(int[] candidates, int[] flag, int target, int sum, List<Integer> list, Set<List<Integer>> result) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                if (sum + candidates[i] < target) {
                    sum += candidates[i];
                    list.add(candidates[i]);
                    flag[i] = 1;
                    result = DFS(candidates, flag, target, sum, list, result);
                    flag[i] = 0;
                    list.remove(list.size() - 1);
                    sum -= candidates[i];
                } else if (sum + candidates[i] == target) {
                    list.add(candidates[i]);
                    List<Integer> integerList = new ArrayList<>(list);
                    Collections.sort(integerList);
                    result.add(integerList);
                    list.remove(list.size() - 1);
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) {
                candidates[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            combinationSum2(candidates, target);
        }
    }
}
