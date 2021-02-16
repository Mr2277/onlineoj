package com.huawei.kexin.leetcodedfs;

public class LeetCode394 {

    public int length = 0;

    public String decodeString(String s) {
        return dfs(s, length);
    }

    public String dfs (String s, int index) {
        int i = index;
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        while (i < s.length()) {
            char cur = s.charAt(i++);
            length++;
            if (cur >= '0' && cur <= '9') {
                num.append(cur);
            } else if (cur == '[') {
                String res = dfs(s, length);
                for (int j = 0; j < Integer.parseInt(num.toString()); j++) {
                    str.append(res);
                }
                num.delete(0, num.length());
                i = length;
            } else if (cur == ']') {
                return str.toString();
            } else {
                str.append(cur);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        //String str = "3[a]2[bc]";
        //String str = "3[a2[c]]";
        String str = "2[2[y]pq4[2[jk]e1[f]]]ef";
        //String str = "4[2[jk]e1[f]]";
        System.out.println(new LeetCode394().decodeString(str));
    }
}
