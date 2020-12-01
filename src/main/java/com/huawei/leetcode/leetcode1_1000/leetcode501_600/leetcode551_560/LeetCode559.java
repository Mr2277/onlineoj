package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode551_560;

import java.util.List;

public class LeetCode559 {

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
    };

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> children = root.children;
        int max = 0;
        for (Node node : children) {
            int childDeep = maxDepth(node);
            max = childDeep > max ? childDeep : max;
        }
        return max + 1;
    }
}
