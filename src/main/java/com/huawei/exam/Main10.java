package com.huawei.exam;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = 0;
            long result = 0L;
            for (int i = 0;i < num;i++) {
                result = (long)i*i;
                String before = String.valueOf(i);
                String after = String.valueOf(result);
                String subAfter = after.substring(after.length() - before.length(), after.length());
                if (subAfter.equals(before)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
