package com.huawei.kexin.exam1023;

import java.util.Scanner;

public class Problem1 {

    public static String replaceIntegerOfString(String str) {
        String num = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur >= '0' && cur <= '9') {
                num += String.valueOf(cur);
            }else {
                for (int k = 0; k < Integer.valueOf(num); k++) {
                    builder.append(cur);
                }
                num = "";
            }
        }
        String replaceIntStr = builder.toString();
        return replaceIntStr;
    }

    public static int matchString(String str1, String str2) {
        String delIntStr1 = replaceIntegerOfString(str1);
        String delIntStr2 = replaceIntegerOfString(str2);
        System.out.println(delIntStr1);
        System.out.println(delIntStr2);
        int count = 0;
        int size = Integer.min(delIntStr1.length(), delIntStr2.length());
        for (int i = 0; i < size; i++) {
           char ch1 = delIntStr1.charAt(i);
           char ch2 = delIntStr2.charAt(i);
           if (ch1 == ch2) {
               count++;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(matchString(str1, str2));
        }


    }
}
