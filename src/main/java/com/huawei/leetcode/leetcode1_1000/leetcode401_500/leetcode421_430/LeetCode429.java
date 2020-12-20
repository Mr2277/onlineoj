package com.huawei.leetcode.leetcode1_1000.leetcode401_500.leetcode421_430;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        path.add(root.val);
        paths.add(path);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                List<Node> children = cur.children;
                if (!children.isEmpty()) {
                    for (Node node : children) {
                        queue.add(node);
                        path.add(node.val);
                    }
                }
            }
            if (!path.isEmpty()) {
                paths.add(path);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        new LeetCode429().levelOrder(null);
    }
}
