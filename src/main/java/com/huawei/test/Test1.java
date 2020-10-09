package com.huawei.test;

//git log --author=sun --since=2020-08-01 --until=2020-09-01 --format='%aN' | sort -u | while read name; do echo -en "$name\t"; git log --author="$name" --pretty=tformat: --numstat | grep "\(.html\|.java\|.xml\|.properties\)$" | awk '{ add += $1; subs += $2; loc += $1 - $2 } END { printf "added lines: %s, removed lines: %s, total lines: %s\n", add, subs, loc }' -; done


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        /*
        char ch = 'a';
        int num = 0;
        num = ch;
        System.out.println(num);
        */
        /*
        String str = "192.168.192.0";
        String[] strings = str.split("\\.");
        System.out.println(strings.length);
        */
        /*
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if ((n & 1) == 1) {
                System.out.println("qi");
            } else {
                System.out.println("ou");
            }
        }
        */
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        System.out.println(map.remove("test"));

    }
}
