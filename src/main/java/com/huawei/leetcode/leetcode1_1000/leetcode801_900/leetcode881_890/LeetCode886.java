package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode881_890;


import java.util.*;

public class LeetCode886 {
    /*
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
    */
    /*
    public static boolean possibleBipartition(int N, int[][] dislikes) { {
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
        boolean result = true;
        boolean isBreak = false;
        int[] colours = new int[N];
        for (int i = 0; i < N; i++) {
            if (colours[i] == 0) {
                colours[i] = 1;
            }
            List<Integer> dislikeList = dislikeMap.get(i);
            for (Integer integer : dislikeList) {
                if (colours[integer - 1] == 0) {
                    colours[integer - 1] = colours[i] == 1 ? 2 : 1;
                } else if (colours[integer - 1] == colours[i]) {
                    result = false;
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                break;
            }
        }
        return result;
    }
    }
    */
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] colors = new int[N + 1];

        for (int i = 1; i < N + 1; i++){
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue=new LinkedList<>();
            colors[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int color = colors[curr];
                int nextColor = color == 1 ? 2 : 1;
                for(int neighbor : graph.get(curr)) {
                    if(colors[neighbor] == 0) {
                        colors[neighbor] = nextColor;
                        queue.add(neighbor);
                    } else if (colors[neighbor] != nextColor) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
       int[][] dislikes = new int[][] {{1,2},{1,3},{2,4}};
       possibleBipartition(4, dislikes);
    }
}
