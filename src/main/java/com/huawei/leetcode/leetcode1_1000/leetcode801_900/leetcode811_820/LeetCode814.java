package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode811_820;

public class LeetCode814 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            boolean left = judge(root.left);
            if (!left) {
                root.left = null;
            }
            boolean right = judge(root.right);
            if (!right) {
                root.right = null;
            }
            pruneTree(root.left);
            pruneTree(root.right);
            if (root.val == 0 && root.right == null && root.left == null) {
                return null;
            }
            return root;
        }
    }

    public boolean judge(TreeNode node) {
        if (node == null) {
            return false;
        } else {
            return node.val == 1 ? true : false || judge(node.left) || judge(node.right);
        }
    }
}
