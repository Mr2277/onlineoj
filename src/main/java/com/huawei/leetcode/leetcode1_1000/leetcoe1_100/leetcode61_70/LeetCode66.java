package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode61_70;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        int cur = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1 + carry;
                if(sum >= 10) {
                    cur = sum - 10;
                    carry = 1;
                } else {
                    cur = sum;
                    carry = 0;
                }
                //list.add(cur);
            } else {
                sum = digits[i] + carry;
                if (sum >= 10) {
                    cur = sum - 10;
                    carry = 1;
                } else {
                    cur = sum;
                    carry = 0;
                }
                //list.add(cur);
            }
            list.add(cur);
        }
        if (carry == 1) {
            list.add(carry);
        }
        Collections.reverse(list);
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static void main(String[] args) {
        LeetCode66 leetCode66 = new LeetCode66();
        int[] digits = new int[] {9};
        int[] res = leetCode66.plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
