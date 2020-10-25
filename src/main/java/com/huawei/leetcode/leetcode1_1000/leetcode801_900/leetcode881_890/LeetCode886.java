package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode881_890;


import java.util.*;

public class LeetCode886 {

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> dislikeMap = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int persionId = dislikes[i][0];
            int dislikeId = dislikes[i][1];
            if (!dislikeMap.containsKey(persionId)) {
                List<Integer> dislikeList = new ArrayList<>();
                dislikeList.add(dislikeId);
                dislikeMap.put(persionId, dislikeList);
            } else {
                List<Integer> dislikeList = dislikeMap.get(persionId);
                dislikeList.add(dislikeId);
            }
            if (!dislikeMap.containsKey(dislikeId)) {
                List<Integer> dislikeList = new ArrayList<>();
                dislikeList.add(persionId);
                dislikeMap.put(dislikeId, dislikeList);
            } else {
                List<Integer> dislikeList = dislikeMap.get(dislikeId);
                dislikeList.add(persionId);
            }
        }
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        Set<Integer> alreadySearchSet = new HashSet<>();
        boolean result = true;
        for (int i = 1; i <= N; i++) {
            List<Integer> dislikeList = dislikeMap.get(i);
            if (alreadySearchSet.contains(i)) {
                continue;
            }
            if (aSet.isEmpty()) {
                aSet.add(i);
                alreadySearchSet.add(i);
            }
            if (containsDuplicate(dislikeList, dislikeMap)) {
                for (Integer integer : dislikeList) {
                    bSet.add(integer);
                    alreadySearchSet.add(integer);
                }
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean containsDuplicate(List<Integer> list, Map<Integer, List<Integer>> dislikeMap) {
        boolean result = true;
        boolean isBreak = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); i++) {
                if (i == j) {
                    continue;
                } else {
                    List<Integer> disList = dislikeMap.get(j);
                    for (Integer integer : disList) {
                        if (integer == list.get(i)) {
                            result = false;
                            isBreak = true;
                            break;
                        }
                    }
                }
            }
            if (isBreak) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
