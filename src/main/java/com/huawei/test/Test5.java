package com.huawei.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test5 {

    public static void foreachNum(List<Integer>list) {
        list.remove(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            foreachNum(list);
        }
    }
}
