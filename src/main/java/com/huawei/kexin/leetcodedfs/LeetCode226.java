package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right =  invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public void printf(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printf(root.left);
        printf(root.right);
    }

    public static void main(String[] args) {
        String str = "4(2(1,3),7(6,9))";
        TreeNode root = TreeNode.create(str);
        LeetCode226 leeetCode226 = new LeetCode226();
        root = leeetCode226.invertTree(root);
        leeetCode226.printf(root);
    }
}
