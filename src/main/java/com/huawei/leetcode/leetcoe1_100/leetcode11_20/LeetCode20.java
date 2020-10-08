package com.huawei.leetcode.leetcoe1_100.leetcode11_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode20 {

    public static boolean isValid(String s) {
        boolean result = false;
        Stack<String> stack = new Stack<>();
        String curChar = "";
        Map<String, String> symbolMap = new HashMap<>();
        symbolMap.put("(", ")");
        symbolMap.put("{", "}");
        symbolMap.put("[", "]");
        for (int i = 0; i < s.length(); i++) {
            curChar = String.valueOf(s.charAt(i));
            if (stack.isEmpty()) {
                stack.push(curChar);
            } else {
                String stackTop = stack.peek();
                String topMapSymbol = symbolMap.get(stackTop);
                if (topMapSymbol != null && topMapSymbol.equals(curChar)) {
                    stack.pop();
                } else if (topMapSymbol != null && !topMapSymbol.equals(curChar)){
                    stack.push(curChar);
                }
            }
        }
        if (stack.isEmpty()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(isValid(s));
        }
    }
}
