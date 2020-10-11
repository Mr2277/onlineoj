package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode21_30;

import java.util.Scanner;

public class LeetCode28 {

    public static int strStr(String haystack, String needle) {
        int lengthHayStack = haystack.length();
        int lengthNeedle = needle.length();
        int result = -1;
        if (lengthNeedle == 0 || haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= lengthHayStack - lengthNeedle; i++) {
            String subString = haystack.substring(i, lengthNeedle + i);
            if (subString.equals(needle)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String haystack = scanner.nextLine();
            String needle = scanner.nextLine();
            System.out.println(strStr(haystack, needle));
        }
    }
}
