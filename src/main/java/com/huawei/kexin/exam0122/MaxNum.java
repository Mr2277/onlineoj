package com.huawei.kexin.exam0122;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxNum {

    public static int composeMaxNum(String A, String B) {
        List<String> newNums = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= A.length(); i++) {
            String left = A.substring(0, i);
            String right = A.substring(i, A.length());
            builder.append(left);
            builder.append(B);
            builder.append(right);
            newNums.add(builder.toString());
            builder.delete(0, builder.toString().length());
        }
        for (String str : newNums) {
            System.out.println(str);
        }
        Integer max = newNums.stream().map(str -> Integer.parseInt(str)).max(Integer::compare).get();
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            System.out.println(composeMaxNum(A, B));
        }
    }
}
