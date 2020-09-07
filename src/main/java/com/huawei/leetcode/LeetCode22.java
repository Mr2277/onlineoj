package com.huawei.leetcode;

import java.util.*;

public class LeetCode22 {

    private  static Integer count = 0;

    public static List<String> DFS(List<Integer> list, int index, int[]flag, List<String> result, int n) {
        if (index < flag.length - 1) {
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == 0) {
                    flag[i] = 1;
                    list.add(i);
                    result = DFS(list, index + 1, flag, result, n);
                    list.remove(list.size() - 1);
                    flag[i] = 0;
                }
            }
        } else {
            for (int i = index; i >= 0; i--) {
                if(flag[i] == 0) {
                    flag[i] = 1;
                    list.add(i);
                }
                if (list.size() == n) {
                    StringBuilder builder = new StringBuilder();
                    for (Integer integer : list) {
                        builder.append(integer);
                    }
                    result.add(builder.toString());
                    list.remove(list.size() - 1);
                    flag[i] = 0;
                   break;
                }
            }
        }
        return result;
    }

    public static List<String> generateParenthesis(List<String> list, int n) {
        List<String> result = new ArrayList<>();
        Map<String, String> symbolMap = new HashMap<String, String>();
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                symbolMap.put(String.valueOf(i), "(");
            } else {
                symbolMap.put(String.valueOf(i), ")");
            }
        }
        Stack<String> stack = new Stack();
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                String curChar = String.valueOf(s.charAt(i));
                String value = symbolMap.get(curChar);
                builder.append(value);
                if (stack.isEmpty() && value.equals(")")){
                    break;
                } else {
                    if (value.equals("(")) {
                        stack.push(value);
                    } else {
                        String top = stack.peek();
                        if (top.equals("("));
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                result.add(builder.toString());

            }
            builder.delete(0, builder.length());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i + 1);
            }
            List<Integer> temp = new ArrayList<>();
            int[] flag = new int[2 *n];
            List<String> result = new ArrayList<>();
            result = DFS(temp, 0, flag, result, 2 * n);
            System.out.println(result);
            List<String> re = generateParenthesis(result, n);
            System.out.println(re.size());
        }
    }
}
