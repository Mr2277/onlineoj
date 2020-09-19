package com.huawei.test;

public class Test1 {
    public static void main(String[] args) {
        /*
        char ch = 'a';
        int num = 0;
        num = ch;
        System.out.println(num);
        */
        String str = "192.168.192.0";
        String[] strings = str.split("\\.");
        System.out.println(strings.length);
    }
}
