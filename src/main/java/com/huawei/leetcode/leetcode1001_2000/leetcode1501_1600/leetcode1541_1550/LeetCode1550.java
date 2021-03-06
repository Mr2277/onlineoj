package com.huawei.leetcode.leetcode1001_2000.leetcode1501_1600.leetcode1541_1550;

public class LeetCode1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 34, 3, 4, 5, 7, 23, 12};
        LeetCode1550 leetCode1550 = new LeetCode1550();
        System.out.println(leetCode1550.threeConsecutiveOdds(arr));
    }

}
