package com.huawei.leetcode.leetcode31_40;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode32 {
    public static int longestValidParentheses(String s) {
        Stack<String> stack = new Stack();
        boolean lastMatch = false;
        for (int i = 0; i < s.length(); i++) {
            String curcent = String.valueOf(s.charAt(i));
            if (curcent.equals("(")) {
                stack.add(curcent);
            } else if (!stack.isEmpty()) {
                String stackTop = stack.peek();
                if (stackTop.equals("(")) {

                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            longestValidParentheses(s);
        }
    }
}
