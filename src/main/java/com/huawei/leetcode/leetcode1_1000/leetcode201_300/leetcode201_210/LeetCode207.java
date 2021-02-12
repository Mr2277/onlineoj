package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode201_210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
            } else {
                List<Integer> list = map.get(pre[1]);
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }
        int[] nums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] != -1) {
                if (!dfs(nums, map, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[] nums, Map<Integer, List<Integer>> map, int index) {
        if (nums[index] == 1) {
            return false;
        }
        nums[index] = 1;
        if (map.containsKey(index)) {
            List<Integer> list = map.get(index);
            for (Integer integer : list) {
                if (nums[integer] != -1) {
                    if (!dfs(nums, map, integer)) {
                        return false;
                    }
                }
            }
        }
        nums[index] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {{0, 1}, {2, 1}, {3, 2}, {2, 0}, {3, 0}, {0, 3}};
        System.out.println(new LeetCode207().canFinish(4, prerequisites));
    }
}
