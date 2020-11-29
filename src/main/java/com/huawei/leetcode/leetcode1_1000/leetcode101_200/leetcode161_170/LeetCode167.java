package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode161_170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode167 {

    public static int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[numbers.length];
        dfs(numbers, target, flag, list);
        return result;
    }

    public static int[] result = new int[2];
    public static boolean isEnd = false;

    public static void dfs (int[] numbers, int target, boolean[] flag, List<Integer> list) {
        if (list.size() == 2) {
            int sum = list.stream().reduce(Integer::sum).orElse(0);
            if (sum == target) {
                int k = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (flag[i]) {
                        result[k++] = i + 1;
                    }
                }
                isEnd = true;
            }
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                list.add(numbers[i]);
                if (!isEnd) {
                    dfs(numbers, target, flag, list);
                }
                flag[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        /*
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int sum = list.stream().reduce(Integer::sum).orElse(0);
        int max = list.stream().max(Integer::max).orElse(0);
        System.out.println(sum);
        System.out.println(max);
        */
        int[] res = twoSum(numbers, 26);
        System.out.println(res[0] + " " + res[1]);
    }
}
