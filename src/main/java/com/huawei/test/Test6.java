package com.huawei.test;

import java.util.Scanner;

public class Test6 {

    private static Integer count = 0;

    public static void DFS(String choose, String remain) {
        if (remain.length() == 0) {
            System.out.println(choose);
            count ++;
            return;
        }
        for (int i = 0; i < remain.length(); i++) {
            String curChar = String.valueOf(remain.charAt(i));
            choose += curChar;
            String tempRemain = "";
            if (i == 0) {
               tempRemain = remain.substring(1);
            } else if (i == remain.length() - 1) {
                tempRemain = remain.substring(0, remain.length() - 1);
            } else {
                tempRemain = remain.substring(0, i) + remain.substring(i + 1);
            }
            DFS(choose , tempRemain);
            choose = choose.substring(0, choose.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append(i + 1);
            }
            DFS("", builder.toString());
            System.out.println(count);
            /*
            //System.out.println(builder.toString().substring(0, 1));
            String str = builder.toString();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(0, 1));
            stringBuilder.append(str.substring(2));
            System.out.println(str);
            System.out.println(stringBuilder.toString());

            */
        }
    }
}
