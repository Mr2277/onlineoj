package com.huawei.leetcode.jianqiaooffer;

public class Offer55 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int leftDepth = treeDepth(root.left);
            int rightDepth = treeDepth(root.right);
            return Math.abs(leftDepth - rightDepth) > 1 ? false : true && isBalanced(root.left) && isBalanced(root.right);

        }
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Integer.max(leftDepth, rightDepth) + 1;
    }
}
