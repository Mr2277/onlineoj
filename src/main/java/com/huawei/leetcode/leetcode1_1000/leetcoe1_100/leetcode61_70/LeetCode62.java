package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode61_70;

import java.util.ArrayList;
import java.util.List;

public class LeetCode62 {

    static class Direction {
        int x;
        int y;
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int uniquePaths(int m, int n) {
        double res = 1;
        for (int i = 1; i < n; i++) res = res * (m - 1 + i) / i;
        return (int)res;


    }

    public List<List<Direction>> DFS(List<List<Direction>> paths, List<Direction> path, Direction target, Direction cur) {
        if (cur.x < 0 || cur.x > target.x || cur.y < 0 || cur.y > target.y ) {
            return paths;
        }else if (cur.x == target.x && cur.y == target.y) {
            List<Direction> copyPath = new ArrayList<>(path);
            paths.add(copyPath);
            return paths;
        } else {
            path.add(cur);
            Direction down = new Direction(cur.x + 1, cur.y);
            DFS(paths, path,target, down);
            Direction right = new Direction(cur.x, cur.y + 1);
            DFS(paths, path, target, right);
            path.remove(path.size() - 1);
            return paths;
        }
    }
}
