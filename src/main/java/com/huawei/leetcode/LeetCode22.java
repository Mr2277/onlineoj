package com.huawei.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode22 {

    private  static Integer count = 0;

    public static void DFS(List<Integer> list, int index, int[]flag) {
        if (index < flag.length - 1) {
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == 0) {
                    flag[i] = 1;
                    list.add(i+1);
                    DFS(list, index + 1, flag);
                    list.remove(list.size() - 1);
                    flag[i] = 0;
                }
            }
        } else {
            for (int i = index; i >= 0; i--) {
                if(flag[i] == 0) {
                    flag[i] = 1;
                    list.add(i);
                }
                if (list.size() == 4) {
                    for (Integer integer : list) {
                        System.out.print(integer + " ");
                    }
                    count ++;
                    System.out.println();
                    list.remove(list.size() - 1);
                    flag[i] = 0;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i + 1);
            }
            List<Integer> temp = new ArrayList<>();
            int[] flag = new int[n];
            DFS(temp, 0, flag);
            System.out.println(count);
        }
    }
}
