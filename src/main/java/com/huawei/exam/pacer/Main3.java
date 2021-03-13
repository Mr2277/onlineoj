package com.huawei.exam.pacer;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            for(int i = str.length() - 1; i >= 0; i--) {
                System.out.print(str.charAt(i));
            }
        }
    }
}
