package com.huawei.leetcode.leetcode11_20;

import java.util.*;

public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        Map<String, String> numMap = new HashMap<String, String>();
        numMap.put("2", "abc");
        numMap.put("3", "def");
        numMap.put("4", "ghi");
        numMap.put("5", "jkl");
        numMap.put("6", "mno");
        numMap.put("7", "pqrs");
        numMap.put("8", "tuv");
        numMap.put("9", "wxyz");
        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        DFS(digits, numMap, 0, result, builder);
        return null;
    }
    public static List<String> DFS(String digits, Map<String, String> numMap, int level, List<String> result, StringBuilder builder) {
        String curNum = String.valueOf(digits.charAt(level));
        String curStr = numMap.get(curNum);
        for (int i = 0; i < curStr.length(); i++) {
            String curChar = String.valueOf(curStr.charAt(i));
            if (level < digits.length() - 1) {
                builder.append(curChar);
                result = DFS(digits, numMap, level + 1, result, builder);
                builder.deleteCharAt(level);
            } else {
                builder.append(curChar);
                if (builder.length() == digits.length()) {
                    result.add(builder.toString());
                }
                builder.deleteCharAt(level);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strs = scanner.nextLine();
            letterCombinations(strs);
        }
    }
}
