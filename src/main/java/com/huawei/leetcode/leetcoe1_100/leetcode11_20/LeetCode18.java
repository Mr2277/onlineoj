package com.huawei.leetcode.leetcoe1_100.leetcode11_20;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        result = DFS(nums, target, result, tempList, 0, true, 0);
        // List<List<Integer>> disresut = (List<List<Integer>>) result.stream().distinct();
        List list=(List) result.stream().distinct().collect(Collectors.toList());

        return list;
    }


    public static List<List<Integer>> DFS(int[] nums, int target, List<List<Integer>> result, List<Integer> tempList, int curIndex, boolean isRecursive, int sum) {
        if (isRecursive) {
            for (int i = curIndex; i < nums.length; i++) {
                sum += nums[i];
                tempList.add(nums[i]);
                if (tempList.size() < 2) {
                    if ((target >= 0 && sum <= target) || (target < 0 && sum < 0)) {
                        result = DFS(nums, target, result, tempList, i + 1, true, sum);
                    }
                } else {
                    result = DFS(nums, target, result, tempList, i + 1, false, sum);
                }
                sum -= nums[i];
                tempList.remove(tempList.size() - 1);
            }
        } else {
            int left = curIndex;
            int right = nums.length - 1;
            int tempSum = sum;
            while (left < right) {
                tempSum = tempSum + nums[left] + nums[right];
                if (tempSum == target) {
                    List<Integer> list = new ArrayList<>(tempList);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    tempSum = sum;
                    left ++;
                    right --;
                } else if(tempSum < target) {
                    tempSum = sum;
                    left ++;
                } else  {
                    tempSum = sum;
                    right --;
                }
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
            int target = scanner.nextInt();
            fourSum(nums, target);
        }
    }
}
