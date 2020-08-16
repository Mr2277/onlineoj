package com.huawei.sort;

import java.util.Scanner;

public class HillSort {
    public static void hillSort(int[] array) {
        for(int k = array.length / 2; k > 0; k = k / 2) {

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        while (scanner.hasNext()) {
            for (int i = 0; i < num; i++) {
                array[i] = scanner.nextInt();
            }
            hillSort(array);
        }
    }
}
