package com.huawei.test;

import java.util.*;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<String>();
            list.add("str");
            list.add("ddd");
            set.add("str");
            List<String> update = list.stream().filter(a -> set.contains(a)).collect(Collectors.toList());
            List<String> insert = list.stream().filter(a -> !set.contains(a)).collect(Collectors.toList());
            for (String s : update) {
                System.out.println(s);
            }
            for (String s : insert) {
                System.out.println(s);
            }
        }
    }
}
