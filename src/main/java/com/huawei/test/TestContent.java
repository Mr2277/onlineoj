package com.huawei.test;

public class TestContent {
    public static void main(String[] args) {
       String str = "\\d+(.\\d+)*";
       String s = "3.4";
       System.out.println(s.matches(str));
    }
}
