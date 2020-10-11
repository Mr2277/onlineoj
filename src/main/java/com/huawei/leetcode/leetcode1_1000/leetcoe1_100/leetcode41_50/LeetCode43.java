package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode41_50;

import java.math.BigInteger;
import java.util.Scanner;

public class LeetCode43 {
    public static String multiply(String num1, String num2) {
        BigInteger integer1 = new BigInteger(num1);
        BigInteger integer2 = new BigInteger(num2);
        BigInteger integer3 = integer1.multiply(integer2);
        String result = integer3.toString();
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num1 = scanner.nextLine();
            String num2 = scanner.nextLine();
            multiply(num1, num2);
        }
    }
}
