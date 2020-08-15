package com.huawei.exam;

import java.util.*;
public class Main5 {
    public static void completion(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            count++;
            if (count == 8) {
                count = 0;
                System.out.println();
            }
        }
        while (count < 8) {
            System.out.print("0");
            count++;
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            for(int i=0; i<n; i++) {
                String temp = sc.next();
                completion(temp);
            }
        }
    }
}