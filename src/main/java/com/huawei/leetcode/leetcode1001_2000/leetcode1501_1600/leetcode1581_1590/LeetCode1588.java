package com.huawei.leetcode.leetcode1001_2000.leetcode1501_1600.leetcode1581_1590;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int size = 1;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        while (size <= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < i + size; j++) {
                    list.add(arr[j]);
                    if (j == arr.length - 1) {
                        break;
                    }
                }
                if (list.size() == size) {
                    int sum = list.stream().mapToInt(Integer::intValue).sum();
                    res += sum;
                }
                list.clear();
            }
            size += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 5, 3};
        LeetCode1588 leetCode1588 = new LeetCode1588();
        System.out.println(leetCode1588.sumOddLengthSubarrays(arr));
    }
}
