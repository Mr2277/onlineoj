package com.huawei.kexin.exam1023;

import java.util.*;

public class Problem3 {
    /*
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
    */
    static class CurrentInfo {
       int index;
       int sum;
       int step;
       int back;
       List<Integer> path;
       CurrentInfo (int index, int sum, int step, int back) {
           this.back = back;
           this.index = index;
           this.step = step;
           this.sum = sum;
           this.path = new ArrayList<>();
       }
    }

    public static int maxSum(int[] nums, int step, int back, int index) {
        List<CurrentInfo> currentInfos = new ArrayList<>();
        CurrentInfo currentInfo = new CurrentInfo(index, nums[index], step, back);
        currentInfo.path.add(index);
        currentInfos.add(currentInfo);
        int max = Integer.MIN_VALUE;
        int front = 0, rear = 1;
        while (rear > front) {
            CurrentInfo cur = currentInfos.get(front++);
            if (cur.back > 0 && cur.step > 0) {
                int newBack = cur.back - 1;
                int newStep = cur.step - 1;
                int newIndex = cur.index - 1;
                int newSum = cur.sum + nums[newIndex];
                CurrentInfo newCurentInfo = new CurrentInfo(newIndex, newSum, newStep, newBack);
                newCurentInfo.path.addAll(cur.path);
                newCurentInfo.path.add(newIndex);
                currentInfos.add(newCurentInfo);
                rear++;
            }
            if (cur.step > 0) {
                int newBack = cur.back;
                int newStep = cur.step - 1;
                int newIndex = cur.index + 1;
                int newSum = cur.sum + nums[newIndex];
                CurrentInfo newCurrentInfo = new CurrentInfo(newIndex, newSum, newStep, newBack);
                newCurrentInfo.path.addAll(cur.path);
                newCurrentInfo.path.add(newIndex);
                currentInfos.add(newCurrentInfo);
                rear++;
            }
            if (cur.step == 0 && cur.sum > max) {
                max = cur.sum;
            }
        }
        for (CurrentInfo currentInfo1 : currentInfos) {
            System.out.println("index:" + currentInfo1.index + "sum:" + currentInfo1.sum
            + "step:" + currentInfo1.step + "back:" + currentInfo1.back);
            for (Integer integer : currentInfo1.path) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        return max;
    }
        //return 0;


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
