package com.huawei.kexin.exam1023;

import java.util.*;

public class DisLike {

    public int splitGroup(int n, int[][] dislike) {
        Map<Integer, List<Integer>> disMap = new HashMap<>();
        for (int[] personId : dislike) {
            if (!disMap.containsKey(personId[0])) {
                List<Integer> personIds = new ArrayList<>();
                personIds.add(personId[1]);
                disMap.put(personId[0], personIds);
            } else {
                List<Integer> personIds = disMap.get(personId[0]);
                personIds.add(personId[1]);
                disMap.put(personId[0], personIds);
            }
            if (!disMap.containsKey(personId[1])) {
                List<Integer> personIds = new ArrayList<>();
                personIds.add(personId[0]);
                disMap.put(personId[1], personIds);
            } else {
                List<Integer> personIds = disMap.get(personId[1]);
                personIds.add(personId[0]);
                disMap.put(personId[1], personIds);
            }
        }
        List<Integer> groups = new ArrayList<>();
        Map<Integer, Integer> idGroupMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> copyGroups = new ArrayList<>(groups);
            if (groups.isEmpty()) {
                groups.add(0);
                idGroupMap.put(i, 0);
            } else {
                List<Integer> disIds = disMap.get(i);
                for (Integer disId : disIds) {
                    if (idGroupMap.containsKey(disId)) {
                        Integer delGroupId = idGroupMap.get(disId);
                        copyGroups.remove(delGroupId);
                    }
                }
                if (copyGroups.isEmpty()) {
                    int newGroupId = groups.size();
                    groups.add(newGroupId);
                    idGroupMap.put(i, newGroupId);
                } else {
                    idGroupMap.put(i, copyGroups.get(0));
                }
            }
        }
        System.out.println(idGroupMap.size());
        System.out.println(idGroupMap.size());
        return 0;
    }

    public static void main(String[] args) {
        int[][] dislike = new int[][] {{1, 2}, {2, 3}, {4, 1}, {5, 2}, {6, 3}, {3, 1}};
        new DisLike().splitGroup(6, dislike);
    }
}
