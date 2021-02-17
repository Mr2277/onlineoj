package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        dfs(s, lists, list);
        return lists;
    }

    public List<List<String>> dfs(String s, List<List<String>> lists, List<String> list) {
        if (s.length() == 0) {
            List<String> copy = new ArrayList<>(list);
            int i = 0;
            for (i = 0; i < copy.size(); i++) {
                if (!isPalindrome(copy.get(i))) {
                    break;
                }
            }
            if (i == copy.size()) {
                lists.add(copy);
            }
            return lists;
        }
        for (int i = 1; i <= s.length(); i++) {
            String cur = s.substring(0, i);
            String next = s.substring(i, s.length());
            list.add(cur);
            dfs(next, lists, list);
            list.remove(list.size() - 1);
        }
        return lists;
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
