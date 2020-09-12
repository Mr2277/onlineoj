package com.huawei.leetcode.leetcode1_10;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> windows = new LinkedHashMap<String, Integer>();
        int left = 0, right = 0, max = 0, maxTemp = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (windows.isEmpty()) {
                windows.put(str, i);
                right++;
                max = right - left;
                maxTemp = max;
            } else {
                if (windows.containsKey(str)) {
                    left = windows.get(str);
                    Iterator iterator = windows.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = (Map.Entry) iterator.next();
                        Integer value = (Integer) entry.getValue();
                        if (value <= left) {
                            iterator.remove();
                        } else {
                            break;
                        }
                    }
                    windows.put(str, i);
                    right++;
                    left++;
                    maxTemp = right - left;
                    if (maxTemp > max) {
                        max = maxTemp;
                    }
                } else {
                    right++;
                    windows.put(str, i);
                    maxTemp = right - left;
                    if (maxTemp > max) {
                        max = maxTemp;
                    }
                }
            }
        }
        return max;
    }
}
public class Leetcode3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            Solution solution = new Solution();
            solution.lengthOfLongestSubstring(str);
        }
    }
}
