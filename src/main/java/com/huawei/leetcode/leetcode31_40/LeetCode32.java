package com.huawei.leetcode.leetcode31_40;

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
            } else if (!stack.isEmpty()) {
                Map<Integer, String> stackTop = stack.peek();
                Iterator iterator = stackTop.entrySet().iterator();
                while (iterator.hasNext()) {

                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            longestValidParentheses(s);
        }
    }
}
