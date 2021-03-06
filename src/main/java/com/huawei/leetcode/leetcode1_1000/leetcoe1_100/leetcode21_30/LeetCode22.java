package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode21_30;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode22 {
    /*
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
    */
     /*
    public static List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                builder.append("(");
            } else {
                builder.append(")");
            }
        }
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        Map<String, String> search = new HashMap<>();
        List<String> symbols = DFS(builder.toString(), stack, result, "", search);
        List<String> finalResult = symbols.stream().distinct().collect(Collectors.toList());
        for (String s : finalResult) {
            System.out.println(s);
        }
        return symbols;
    }

    public static List<String> DFS(String str, Stack<String> stack, List<String> result, String tempStr, Map<String, String> search) {
        if (str.length() == 0) {
            result.add(tempStr);
            return result;
        }
        for (int i = 0; i < str.length(); i++) {
            String curString = String.valueOf(str.charAt(i));
            String subStr = "";
            if (tempStr.length() == 0 && curString.equals(")")) {
                break;
            }
            if (curString.equals("(")) {
                tempStr += curString;
                stack.push(curString);
                if (i == 0) {
                    subStr = str.substring(1);
                } else if (i == str.length()) {
                    subStr = str.substring(0, str.length() - 1);
                } else {
                    subStr = str.substring(0, i) + str.substring(i + 1);
                }
                if (search.containsKey(tempStr)) {
                    search.add(subStr);
                    result = DFS(subStr, stack, result, tempStr, search);
                    tempStr = tempStr.substring(0, tempStr.length() - 1);
                    stack.pop();
                }
            }
            if (!stack.isEmpty() && curString.equals(")")) {
                String stackTop = stack.peek();
                if (stackTop.equals("(")) {
                    stack.pop();
                    if (i == 0) {
                        subStr = str.substring(1);
                    } else if (i == str.length()) {
                        subStr = str.substring(0, str.length() - 1);
                    } else {
                        subStr = str.substring(0, i) + str.substring(i + 1);
                    }
                    tempStr += curString;
                    search.add(subStr);
                    result = DFS(subStr, stack, result, tempStr, search);
                    stack.add(stackTop);
                    tempStr = tempStr.substring(0, tempStr.length() - 1);
                }
            }
        }
        return result;
    }
     */
    public  static List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                builder.append("(");
            } else {
                builder.append(")");
            }
        }
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        List<String> symbols = DFS(builder.toString(), stack, result, "");
        List<String> finalResult = symbols.stream().distinct().collect(Collectors.toList());

        return finalResult;
    }

    public  static List<String> DFS(String str, Stack<String> stack, List<String> result, String tempStr) {
        if (str.length() == 0) {
            result.add(tempStr);
            return result;
        }
        for (int i = 0; i < str.length(); i++) {
            String curString = String.valueOf(str.charAt(i));
            String subStr = "";
            if (tempStr.length() == 0 && curString.equals(")")) {
                break;
            }
            if (curString.equals("(")) {
                tempStr += curString;
                stack.push(curString);
                if (i == 0) {
                    subStr = str.substring(1);
                } else if (i == str.length()) {
                    subStr = str.substring(0, str.length() - 1);
                } else {
                    subStr = str.substring(0, i) + str.substring(i + 1);
                }
                result = DFS(subStr, stack, result, tempStr);
                tempStr = tempStr.substring(0, tempStr.length() - 1);
                stack.pop();
            }
            if (!stack.isEmpty() && curString.equals(")")) {
                String stackTop = stack.peek();
                if (stackTop.equals("(")) {
                    stack.pop();
                    if (i == 0) {
                        subStr = str.substring(1);
                    } else if (i == str.length()) {
                        subStr = str.substring(0, str.length() - 1);
                    } else {
                        subStr = str.substring(0, i) + str.substring(i + 1);
                    }
                    tempStr += curString;
                    result = DFS(subStr, stack, result, tempStr);
                    stack.add(stackTop);
                    tempStr = tempStr.substring(0, tempStr.length() - 1);
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            generateParenthesis(n);
            /*
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
            */
        }
    }
}
