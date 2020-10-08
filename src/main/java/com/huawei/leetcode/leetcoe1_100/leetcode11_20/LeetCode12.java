package com.huawei.leetcode.leetcoe1_100.leetcode11_20;

import java.util.Scanner;

public class LeetCode12 {
    public static String intToRoman(int num) {
        String[] M = {"","M","MM","MMM"};
        String[] C =  {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I =  {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String result = M[num / 1000] + C[num / 100 % 10] + X[num / 10 % 10] + I[num % 10];
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(intToRoman(num));
        }
    }
}
