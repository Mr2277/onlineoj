package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

public class Interview0406 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == p) {
            return root.right;
        }
        dfs(root, p);
        return target;
    }

    public TreeNode target;

    public boolean dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            if (root.right != null) {
                target = next(root.right);
            }
            return true;
        }
        boolean left = dfs(root.left, p);
        if (left && target == null) {
            target = root;
            return false;
        }
        boolean right = dfs(root.right, p);

        return right;
    }

    public TreeNode next(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        TreeNode left = next(node.left);
        if (left != null) {
            return left;
        }
        TreeNode right = next(node.right);
        if (right != null) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "5(3(2(1,#),4),6)";
        TreeNode root = TreeNode.create(str);
        new Interview0406().inorderSuccessor(root, root.left.right);
    }
}
