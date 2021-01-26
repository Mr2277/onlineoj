package com.huawei.test;

//git log --author=sun --since=2020-08-01 --until=2020-09-01 --format='%aN' | sort -u | while read name; do echo -en "$name\t"; git log --author="$name" --pretty=tformat: --numstat | grep "\(.html\|.java\|.xml\|.properties\)$" | awk '{ add += $1; subs += $2; loc += $1 - $2 } END { printf "added lines: %s, removed lines: %s, total lines: %s\n", add, subs, loc }' -; done


import java.util.*;

public class Test1 {

    public static void change(List<Integer> list) {
        list.add(5);
        list.add(4);
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append(-57);
        builder.append("#");
        System.out.println();
    }
}
