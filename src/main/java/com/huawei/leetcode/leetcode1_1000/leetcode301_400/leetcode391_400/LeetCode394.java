package com.huawei.leetcode.leetcode1_1000.leetcode301_400.leetcode391_400;

public class LeetCode394 {
    public String decodeString(String s) {
        String[] strs = s.split("#");
        int index = strs.length == 1 ? 0 : Integer.parseInt(strs[1]);
        StringBuilder numBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while(index < s.length()) {
            char cur = s.charAt(index++);
            if (cur >= '0' && cur <= '9') {
                numBuilder.append(cur);
            } else if (cur == '['){
                String subStr = s.substring(index, s.length());
                String subResult = decodeString(subStr);
                String[] subResults = subResult.split("#");
                index += Integer.parseInt(subResults[1]);
                for (int j = 0; j < Integer.parseInt(numBuilder.toString()); j++) {
                    result.append(subResults[0]);
                }
                numBuilder.delete(0, numBuilder.length());
            } else if (cur != ']') {
                result.append(cur);
            } else {
                return result.toString() + "#" + index;
            }
        }
        return result.toString();
    }
}
