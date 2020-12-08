package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode201_210;

import java.util.*;

public class LeetCode210 {
    /*
    public boolean isHas = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            set.add(i);
        }
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                set.remove(pre[0]);
                map.put(pre[1], list);
            } else {
                List<Integer> list = map.get(pre[1]);
                list.add(pre[0]);
                set.remove(pre[0]);
                map.put(pre[1], list);
            }
        }
        boolean[] flag = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (Integer key : set) {
            queue.add(key);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer integer = queue.poll();
                    if (flag[integer]) {
                        isHas = false;
                    } else {
                        flag[integer] = true;
                        result.add(integer);
                        if (map.containsKey(integer)) {
                            for (Integer integer1 : map.get(integer)) {
                                queue.add(integer1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result.size());
        return new int[numCourses];
    }
    */

    /*
    public int[] findOrder(int num, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] flag = new boolean[num];
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                flag[pre[0]] = true;
                map.put(pre[1], list);
            } else {
                List<Integer> list = map.get(pre[1]);
                list.add(pre[0]);
                flag[pre[0]] = true;
                map.put(pre[1], list);
            }
        }
        int cur = 0;
        for (int i = 0; i < num; i++) {
            if (!flag[i]) {
                cur = i;
            }
        }
        boolean isXunHuan = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        int[] colors = new int[num];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                colors[cur] = -1;
                if (map.containsKey(cur)) {
                    List<Integer> list = map.get(cur);
                    for (Integer integer : list) {
                        if (colors[integer] == 0) {
                            queue.add(integer);
                            colors[integer] = -1;
                        } else if (colors[integer] == -1) {
                            isXunHuan = true;
                        }
                    }
                }
            }
        }
        if (!isXunHuan) {

        }
        return new int[] {};
    }
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        //创建入度表和哈希表
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if(map.containsKey(prerequisites[i][1])){
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        //遍历，将index入队
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        // 出队，查哈希表，将入度为零的入队
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            res.add(cur);
            if(map.containsKey(cur) && map.get(cur).size() != 0){
                for (Integer num : map.get(cur)) {
                    inDegree[num]--;
                    if(inDegree[num] == 0) queue.offer(num);
                }













            }
        }
        //使用list的流来转为int[]数组，也可以通过遍历一遍完成转换。
        return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];

    }
    public static void main(String[] args) {
        int[][] pre = new int[][] {{1,0},{2,0},{3,1},{3,2}};
        //int[][] pre = new int[][] {{1,0}};
        int[] result = new LeetCode210().findOrder(4, pre);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
