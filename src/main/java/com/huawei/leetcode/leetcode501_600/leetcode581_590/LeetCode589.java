package com.huawei.leetcode.leetcode501_600.leetcode581_590;

import java.util.ArrayList;
import java.util.List;

public class LeetCode589 {

    static class Node {

        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        return DFS(root, result);
    }

    public List<Integer> DFS(Node node, List<Integer> result) {
        if (node == null) {
            return result;
        } else {
            result.add(node.val);
            for (Node n : node.children) {
                DFS(n, result);
            }
            return result;
        }
    }
}
