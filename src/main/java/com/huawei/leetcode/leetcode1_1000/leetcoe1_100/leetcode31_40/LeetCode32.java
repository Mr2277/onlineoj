package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode31_40;

import java.util.*;

public class LeetCode32 {
    public static int longestValidParentheses(String s) {
        Stack<Map<Integer, String>> stack = new Stack();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String curcent = String.valueOf(s.charAt(i));
            if (curcent.equals("(")) {
                Map<Integer, String> map = new HashMap<>();
                map.put(i, curcent);
                stack.add(map);
            } else if (!stack.isEmpty()) {
                Map<Integer, String> stackTop = stack.peek();
                Iterator iterator = stackTop.entrySet().iterator();
                String value = "";
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    value = (String) entry.getValue();
                }
                if (value.equals("(")) {
                    stack.pop();
                } else {
                    Map<Integer, String> map = new HashMap<>();
                    map.put(i, curcent);
                    stack.add(map);
                }
            } else {
                Map<Integer, String> map = new HashMap<>();
                map.put(i, curcent);
                stack.add(map);
            }
        }
        int right = s.length() - 1;
        if (right < 0) {
            return 0;
        }
        if (stack.isEmpty()) {
            return s.length();
        } else {
            while (!stack.isEmpty()) {
                Map<Integer, String> map = stack.pop();
                Iterator iterator = map.entrySet().iterator();
                Integer key = 0;
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    key = (Integer) entry.getKey();
                }
                if (right - key > max) {
                    max = right - key;
                }
                right = key - 1;
            }
            if (right + 1 - 0 > max) {
                max = right + 1;
            }
            return max;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            longestValidParentheses(s);
        }
    }
}
