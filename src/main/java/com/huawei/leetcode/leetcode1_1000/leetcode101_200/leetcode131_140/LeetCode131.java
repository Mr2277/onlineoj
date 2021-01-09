package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode131_140;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    public List<List<String>> partition(String s) {
        List<String> result = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        dfs(s, result, results);
        return results;
    }

    public void dfs(String s, List<String> result, List<List<String>> results) {
        if (s.isEmpty()) {
             List<String> copy = new ArrayList<>(result);
             results.add(copy);
        }
        for (int i = 1; i <= s.length(); i++) {
            String cur = s.substring(0, 0 + i);
            if (isPalindrome(cur)) {
                result.add(cur);
                dfs(s.substring(0 + i, s.length()), result, results);
                result.remove(result.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        boolean result = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "aab";
        new LeetCode131().partition(str);
    }
}
