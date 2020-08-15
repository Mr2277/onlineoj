package com.huawei.exam;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int diff = 3;
        int sum = 0;
        int start = 2;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (i = 0;i < n;i++) {
                sum += start;
                start += diff;
            }
            System.out.println(sum);
            sum = 0;
            start = 2;
        }
    }
}
