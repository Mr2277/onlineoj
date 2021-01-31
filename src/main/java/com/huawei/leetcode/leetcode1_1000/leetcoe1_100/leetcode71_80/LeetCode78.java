package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode71_80;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        result.add(sub);
        Set<String> searched = new HashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(numList);
        for (int i = 0; i < nums.length; i++) {
            sub = new ArrayList<>();
            sub.add(nums[i]);
            queue.add(sub);
            result.add(sub);
            searched.add(sub.toString());
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> cur = queue.poll();
                List<Integer> copy = new ArrayList<>(numList);
                for (Integer integer : cur) {
                    copy.remove(integer);
                }
                for (Integer next : copy) {
                    sub = new ArrayList<>(cur);
                    sub.add(next);
                    List<Integer> keys = sub.stream().sorted().collect(Collectors.toList());
                    if (!searched.contains(keys.toString())) {
                        queue.add(sub);
                        result.add(sub);
                        searched.add(keys.toString());
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        new LeetCode78().subsets(nums);
    }
}
