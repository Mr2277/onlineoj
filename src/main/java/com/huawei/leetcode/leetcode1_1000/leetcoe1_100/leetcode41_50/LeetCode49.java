package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode41_50;

import java.util.*;

public class LeetCode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            char[] chars = curStr.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            /*
            for (int j = 0; j < curStr.length(); j++) {
                charList.add(String.valueOf(curStr.charAt(j)));
                stringBuilder.append(curStr.charAt(j));
            }
            Collections.sort(charList);
            String key = "";
            for (String s : charList) {
                key += s;
            }
            */
            if (!stringListMap.containsKey(key)) {
                List<String> subResult = new ArrayList<>();
                subResult.add(curStr);
                stringListMap.put(key, subResult);
            } else {
                List<String> subResult = stringListMap.get(key);
                subResult.add(curStr);
            }

        }
        Iterator iterator = stringListMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            result.add((List<String>) entry.getValue());
        }
        //System.out.println(result.size());
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }
            groupAnagrams(strings);
        }
    }
}
