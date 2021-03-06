package com.huawei.test;

import java.util.Scanner;

public class Main {
    public static Integer parseInteger(String str) {
        if (str.length() == 0) {
            return null;
        }
        boolean positive = true;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            positive = str.charAt(0) == '-' ? false : true;
            str = str.substring(1, str.length());
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            StringBuilder builder = new StringBuilder();
            boolean delZero = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    delZero = false;
                }
                if (!delZero) {
                    builder.append(str.charAt(i));
                }
            }
            String[] strings = builder.toString().split("e");
            int result = 0;
            if (strings.length == 2) {
                Integer num = Integer.parseInt(strings[0]);
                Integer zhishu = Integer.parseInt(strings[1]);
                Integer pow = (int) Math.pow(10, zhishu);
                result = positive ? num * pow
                        : 0 - num * pow;
            } else {
                result = positive ? Integer.parseInt(builder.toString()) : 0 - Integer.parseInt(builder.toString());
            }
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(parseInteger(str));
    }
}
