package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode191_200;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode198 {

    public int max = 0;

    public Set<String> set = new HashSet<>();

    public int rob(int[] nums) {
        int[] flag = new int[nums.length];
        List<Integer> search = new ArrayList<>();
        dfs(flag, 0, nums, search);
        return max;
    }

    public void dfs(int[] flag, int sum, int[] nums, List<Integer> search) {
        boolean result = false;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                result = true;
                flag[i]++;
                search.add(i);
                sum += nums[i];
                if (i - 1 >= 0) {
                    flag[i - 1]++;
                }
                if (i + 1 < flag.length) {
                    flag[i + 1]++;

                }
                String str = search.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
                if (!set.contains(str)) {
                    set.add(str);
                    dfs(flag, sum, nums, search);
                }
                sum -= nums[i];
                search.remove(search.size() - 1);
                if (i - 1 >= 0) {
                    flag[i - 1]--;
                }
                if (i + 1 < flag.length) {
                    flag[i + 1]--;
                }
                flag[i]--;
            }
        }
        if (!result) {
            max = sum > max ? sum : max;
            return;
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {2, 7, 9, 3, 1};
        //int[] nums = new int[] {100};
        int[] nums = new int[] {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
        System.out.println(new LeetCode198().rob(nums));
        //String str = "27931";
        //System.out.println(str.substring(0, 1));
    }
}
