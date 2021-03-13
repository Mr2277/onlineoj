package com.huawei.exam.pacer;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
        int i = 0;
        if (iSortFlag == 0) {
            Arrays.sort(pIntegerArray);
            for (i = 0;i < pIntegerArray.length;i++) {
                if (i < pIntegerArray.length - 1) {
                    System.out.print(pIntegerArray[i] + " ");
                } else {
                    System.out.println(pIntegerArray[i]);
                }
            }
        } else {
            Arrays.sort(pIntegerArray);
            for (i = pIntegerArray.length - 1;i >= 0;i--) {
                if (i > 0) {
                    System.out.print(pIntegerArray[i] + " ");
                } else {
                    System.out.println(pIntegerArray[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int iSortFlag = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Integer[] num = new Integer[n];
            for (i = 0;i < n;i++) {
                num[i] = scanner.nextInt();
            }
            iSortFlag = scanner.nextInt();
            sortIntegerArray(num, iSortFlag);
        }
    }
}
