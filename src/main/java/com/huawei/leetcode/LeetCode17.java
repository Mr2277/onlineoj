package com.huawei.leetcode;

import java.util.*;

public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        String num = String.valueOf(digits.charAt(0));
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        DFS(num, digits, 0, 1, result, stringBuilder);
        return null;
    }
    public static List<String> DFS(String num, String digits, int level, int index, List<String> result, StringBuilder stringBuilder) {
        String indexMapString = getNumMap().get(index);
        if (level == digits.length() && index > indexMapString.length() - 1) {
            result.add(stringBuilder.toString());
        } else {
            String curStr = String.valueOf(indexMapString.charAt(index));
        }
        return result;
    }
    public static Map<String, String> getNumMap() {
        Map<String, String> numMap = new HashMap<String, String>();
        numMap.put("2", "abc");
        numMap.put("3", "def");
        numMap.put("4", "ghi");
        numMap.put("5", "jkl");
        numMap.put("6", "mno");
        numMap.put("7", "pqrs");
        numMap.put("8", "tuv");
        numMap.put("9", "wxyz");
        return numMap;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strs = scanner.nextLine();
            letterCombinations(strs);
        }
    }
}
