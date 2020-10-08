package com.huawei.leetcode.leetcoe1_100.leetcode21_30;

import java.util.*;

public class LeetCode30 {
    /*
    public static List<Integer> findSubstring(String s, String[] words) {
        Arrays.sort(words);
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        } else {
            int wordsLength = words.length;
            int firstWordLength = words[0].length();
            int windowLength = wordsLength * firstWordLength;
            int left = 0, right = windowLength;
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (String s3 : words) {
                stringBuilder.append(s3);
            }
            while (right <= s.length()) {
                String current = s.substring(left, right);
                //Set<String> tempSet = new HashSet<>(wordSet);
                List<String> list = new ArrayList<>();
                for (i = 0; i < current.length(); i += firstWordLength) {
                    String subCurrent = current.substring(i, firstWordLength + i);
                    list.add(subCurrent);
                }
                Collections.sort(list);
                StringBuilder builder = new StringBuilder();
                for (String s1 : list) {
                    builder.append(s1);
                }

                if (builder.toString().equals(stringBuilder.toString())) {
                    result.add(left);
                }
                left ++;
                right ++;
            }
        }
        return result;
    }
    */

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        } else {
            int wordLength = words[0].length();
            int wordsSize = words.length;
            int totelWordsLength = wordLength * wordsSize;
            Map<String, Integer> wordsMap = new HashMap<>();
            Map<String, Integer> subStringMap = new HashMap<>();
            boolean exist = true;
            for (String s1 : words) {
                int count = wordsMap.getOrDefault(s1, 0);
                wordsMap.put(s1, count + 1);
            }
            for (int i = 0; i <= s.length() - totelWordsLength; i++) {
                String current = s.substring(i, totelWordsLength + i);
                subStringMap.clear();
                exist = true;
                for (int j = 0; j < current.length(); j += wordLength) {
                    String subCurrent = current.substring(j, j + wordLength);
                    int num = subStringMap.getOrDefault(subCurrent, 0);
                    subStringMap.put(subCurrent, num + 1);
                }
                if (subStringMap.size() == wordsMap.size()) {
                    Iterator iterator = subStringMap.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = (Map.Entry) iterator.next();
                        String key = (String) entry.getKey();
                        Integer value = (Integer) entry.getValue();
                        if (!wordsMap.containsKey(key) || !wordsMap.get(key).equals(value)) {
                            exist = false;
                            break;
                        }
                    }
                    if (exist) {
                        list.add(i);
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
            }
            */
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        //findSubstring(s, words);
        //Arrays.sort(words);
        List<Integer> list = findSubstring(s, words);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
