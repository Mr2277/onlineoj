package com.huawei.leetcode.leetcode501_600.leetcode581_590;

import java.util.ArrayList;
import java.util.List;

public class LeetCode590 {

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

        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            result = DFS(root, result);
            if (root != null) {
                result.add(root.val);
            }
            return result;
        }

        public List<Integer> DFS(Node root, List<Integer> result) {
            if (root == null) {
                return result;
            } else {
                for (Node node : root.children) {
                    DFS(node, result);
                    result.add(node.val);
                }
                //result.add(root.val);
                return result;
            }
        }
    }
}
