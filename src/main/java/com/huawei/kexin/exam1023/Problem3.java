package com.huawei.kexin.exam1023;

import java.util.*;

public class Problem3 {

    public static Set<String> alreadySearchSet = new HashSet<>();

    public static int maxSum(int[] nums, int step, int back, int index) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        int[] directions = new int[step];
        boolean[] flag = new boolean[step];
        for (int i = 0; i < step; i++) {
            directions[i] = i < back ? 0 : 1;
            flag[i] = true;
        }
        result = fullPermutation(result, subResult, directions, flag, "");
        int maxSum = Integer.MIN_VALUE;
        for (List<Integer> list : result) {
            int curIndex = index;
            int sum = nums[curIndex];
            for (Integer integer : list) {
                sum += integer == 1 ? nums[++curIndex] : nums[--curIndex];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static List<List<Integer>> fullPermutation(List<List<Integer>> result, List<Integer> subResult, int[] directions, boolean[] flag, String key) {
        if (subResult.size() == directions.length) {
            List<Integer> copySub = new ArrayList<>(subResult);
            result.add(copySub);
            return result;
        }
        for (int i = 0; i < directions.length; i++) {
            if (flag[i]) {
                key = key + directions[i];
                subResult.add(directions[i]);
                flag[i] = false;
                if (!alreadySearchSet.contains(key)) {
                    alreadySearchSet.add(key);
                    fullPermutation(result, subResult, directions, flag, key);
                }
                flag[i] = true;
                key = key.substring(0, key.length() - 1);
                subResult.remove(subResult.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int step = scanner.nextInt();
            int back = scanner.nextInt();
            int curIndex = scanner.nextInt();
            System.out.println(maxSum(nums, step, back, curIndex));
        }
    }
}
