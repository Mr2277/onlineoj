package com.huawei.exam;

import java.util.Scanner;

public class Main1 {
    public static int maxYueNum(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
           return maxYueNum(b,(a % b));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println((a * b) / maxYueNum(a,b));
        }
    }
}
