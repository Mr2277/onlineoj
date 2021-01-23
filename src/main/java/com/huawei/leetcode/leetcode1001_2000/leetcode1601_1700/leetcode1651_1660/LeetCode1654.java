package com.huawei.leetcode.leetcode1001_2000.leetcode1601_1700.leetcode1651_1660;

import java.util.*;

public class LeetCode1654 {


    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>(forbidden.length);
        for (int i = 0; i < forbidden.length; i++) {
            forbiddenSet.add(forbidden[i]);
        }
        Set<Integer> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        //new int[]{当前位置,方向(1代表向右,-1代表向左),跳跃次数}
        queue.offer(new int[]{0,1,0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0] == x) {
                return poll[2];
            }

            if(visit.contains(poll[0])) {
                continue;
            }
            visit.add(poll[0]);
            // left jump
            if(poll[1] == 1 && poll[0] - b > 0 && !forbiddenSet.contains(poll[0] - b) ) {
                queue.offer(new int[]{poll[0] - b, -1, poll[2] + 1});
            }

            // right jump
            if (!forbiddenSet.contains(poll[0] + a) && poll[0] + a < 6000) {
                queue.offer(new int[]{poll[0] + a, 1, poll[2] + 1});
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = new int[] {1998};

        int a = 1999;
        int b = 2000;
        int x = 2000;
        System.out.println(new LeetCode1654().minimumJumps(forbidden, a, b, x));
    }
}
