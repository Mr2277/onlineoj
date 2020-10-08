package com.huawei.leetcode.leetcode601_700.leetcode671_680;


import java.util.*;
import java.util.stream.Collectors;

public class LeetCode679 {

    public  boolean judgePoint24(int[] nums) {
        List<Double> numList = Arrays.stream(nums).boxed().map(Double::new)
                .collect(Collectors.toList());
        return dfs(numList);
    }

    private  boolean dfs(List<Double> numList) {
        if (numList.size() == 0) {
            return false;
        }
        if (numList.size() == 1) {
            return Math.abs(Math.abs(numList.get(0) - 24.0)) < 0.000001d;
        }
        for (int i = 0; i < numList.size(); i++) {
            for (int j = i + 1; j < numList.size(); j++) {
                boolean valid = dfs(getList(numList, i, j, 0)) || dfs(getList(numList, i, j, 1))
                        || dfs(getList(numList, i, j, 2)) || dfs(getList(numList, i, j, 3))
                        || dfs(getList(numList, i, j, 4)) || dfs(getList(numList, i, j, 5));
                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }

    private  List<Double> getList(List<Double> numList, int i, int j, int operate) {
        List<Double> candidate = new ArrayList<>();
        for (int k = 0; k < numList.size(); k++) {
            if (k == i || k == j) {
                continue;
            }
            candidate.add(numList.get(k));
        }

        switch (operate) {
            // a + b
            case 0:
                candidate.add(numList.get(i) + numList.get(j));
                break;
            // a - b
            case 1:
                candidate.add(numList.get(i) - numList.get(j));
                break;
            // b - a
            case 2:
                candidate.add(numList.get(j) - numList.get(i));
                break;
            // a * b
            case 3:
                candidate.add(numList.get(i) * numList.get(j));
                break;
            // a / b
            case 4:
                if (numList.get(j) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(i) / numList.get(j));
                break;
            // b / a
            case 5:
                if (numList.get(i) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(j) / numList.get(i));
                break;
        }
        return candidate;
    }
    /*
    public static boolean DFS(List<Double> nums) {
        if (nums.isEmpty()) {
            return false;
        } else if (nums.size() == 1) {
            return Math.abs(Math.abs(nums.get(0) - 24.0)) < 0.000001d;
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    boolean result = DFS(subList(i, j))
                }
            }
        }
    }

    public static List<Double> subList(int i, int j, List<Double> nums, int operate) {
        List<Double> subNums = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            if (k == i || k == j) {
                continue;
            }
            subNums.add(nums.get(i));
        }
        switch (operate) {
            // a + b
            case 0:
                subNums.add(nums.get(i) + nums.get(i));
                break;
            // a * b
            case 1:
                subNums.add(nums.get(i) *  nums.get(j));
                break;
            // a - b
            case 2:
                subNums.add(nums[i] - nums[j]);
                break;
            // a / b
            case 3:
                if (nums[j] == 0) {
                    return Collections.emptyList();
                }
                subNums.add(nums[i] / nums[j]);
                break;
            // b - a
            case 4:
                subNums.add(nums[j] - nums[i]);
                break;
            // b / a
            case 5:
                if (nums[i] == 0) {
                    return Collections.emptyList();
                }
                subNums.add(nums[j] / nums[i]);
                break;;
        }
        return subNums;
    }
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = scanner.nextInt();
            }
            //DFS(nums);
        }
    }
}
