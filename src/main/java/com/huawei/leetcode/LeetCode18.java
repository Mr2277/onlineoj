package com.huawei.leetcode;

import java.util.*;

public class LeetCode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        DFS(nums, 0, list, tempList, 0, target);
        return null;
    }

    public static List<List<Integer>> DFS(int[] nums, int curIndex, List<List<Integer>> list, List<Integer> tempList, int sum, int target) {
        for (int i = 0; i < nums.length; i++) {
            tempList.add(nums[curIndex]);
            if (tempList.size() <= 2) {
                sum += nums[curIndex];
                list = DFS(nums, curIndex + 1, list, tempList, sum, target);
                sum -= nums[curIndex];
                tempList.remove(curIndex);
            } else {
                int left = curIndex;
                int right = nums.length - 1;
                int tempSum = sum;
                while (left < right) {
                    tempSum = tempSum + nums[left] + nums[right];
                    if (tempSum == target) {
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        list.add(tempList);
                        tempList.remove(2);
                        tempList.remove(2);
                        left ++;
                        right --;
                    } else if(tempSum < target) {
                        tempSum = sum;
                        left ++;
                    } else {
                        tempSum = sum;
                        right --;
                    }
                }
            }
        }
        return list;
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
