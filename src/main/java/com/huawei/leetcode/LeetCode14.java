package com.huawei.leetcode;

import java.util.*;

public class LeetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        Set<String> strSet = new LinkedHashSet<String>();
        Boolean isEnd = false;
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (true) {
            String temp =  null;
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    isEnd = true;
                    break;
                } else {
                    temp = String.valueOf(strs[i].charAt(index));
                    strSet.add(temp);
                    if (strSet.size() > 1) {
                        isEnd = true;
                        break;
                    }
                }
            }
            if (isEnd) {
                break;
            } else {
                if (strSet.size() == 1) {
                    stringBuilder.append(temp);
                    strSet.clear();
                } else {
                    break;
                }
                index ++;
            }
        }
        if (stringBuilder.toString().length() > 0) {
            return stringBuilder.toString();
        } else {
            return "";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
            }
            Arrays.sort(strs);
            for (int i = 0; i < n; i++) {
                System.out.println(strs[i]);
            }
            //System.out.println(longestCommonPrefix(strs));
        }
    }
}
