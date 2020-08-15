package com.huawei.sort;

import java.util.Scanner;

public class InsertSort {

    public static void insertSort(int[] array){
        int[] arraySort = new int[array.length];
        arraySort[0] = array[0];
        int i, j, m, k;
        for(i = 1; i < array.length; i++) {
            boolean isMin = true;
            for(j = i - 1; j >= 0; j--) {
                if (array[i] >= arraySort[j]) {
                  int temp = arraySort[j + 1];
                  arraySort[j + 1] = array[i];
                  for(m = j + 2; m < i + 1; m++) {
                      int current = arraySort[m];
                      arraySort[m] = temp;
                      temp = current;
                  }
                  isMin = false;
                  break;
                }
            }
            if (isMin) {
                int temp = arraySort[0];
                arraySort[0] = array[i];
                for(k = 1; k < i + 1; k++) {
                    int current = arraySort[k];
                    arraySort[k] = temp;
                    temp = current;
                }
            }
        }
        for(i = 0; i < arraySort.length; i++) {
            System.out.println(arraySort[i] + "#");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        while (scanner.hasNext()) {
            for(int i = 0;i < num;i++) {
                array[i] = scanner.nextInt();
            }
            insertSort(array);
        }
    }
}
