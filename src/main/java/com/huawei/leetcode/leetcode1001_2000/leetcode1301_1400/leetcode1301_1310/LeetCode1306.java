package com.huawei.leetcode.leetcode1001_2000.leetcode1301_1400.leetcode1301_1310;

public class LeetCode1306 {

    public static boolean canReach(int[] arr, int start) {
        boolean[] flag = new boolean[arr.length];
        return dfs(arr, start, flag);
    }

    public static boolean dfs(int[] arr, int start, boolean[] flag) {
        if (start >= arr.length || start < 0 || flag[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        flag[start] = true;
        boolean right = dfs(arr, start + arr[start], flag);
        boolean left = dfs(arr, start - arr[start], flag);
        flag[start] = false;
        return right || left;
    }



    public static void main(String[] args) {
        int[] array = new int[] {3,0,2,1,2};
        System.out.println(canReach(array, 2));
    }
}
