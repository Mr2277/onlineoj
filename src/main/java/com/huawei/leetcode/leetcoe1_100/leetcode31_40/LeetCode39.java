package com.huawei.leetcode.leetcoe1_100.leetcode31_40;

import java.util.*;

public class LeetCode39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        result = DFS(candidates, target, list, result, 0);
        List<List<Integer>> finalResult = new ArrayList<>(result);

        return finalResult;


    }

    public static Set<List<Integer>> DFS(int[] candidates, int target, List<Integer> list, Set<List<Integer>> result, int sum) {
        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] < target) {
                list.add(candidates[i]);
                sum += candidates[i];
                int temp = candidates[i];
                result = DFS(candidates, target, list, result, sum);
                sum -= temp;
                list.remove(list.size() - 1);
            } else if (sum + candidates[i] == target) {
                list.add(candidates[i]);
                List<Integer> copyList = new ArrayList<>(list);
                Collections.sort(copyList);
                result.add(copyList);
                list.remove(list.size() - 1);
                return result;
            } else {
                return result;
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
            combinationSum(candidates, target);
        }
    }
}
