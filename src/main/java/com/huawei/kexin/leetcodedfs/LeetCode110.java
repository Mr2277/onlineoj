package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

public class LeetCode110 {

    public boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return balance;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return Integer.max(left, right);
    }

    public static void main(String[] args) {
        String str = "3(9,20(15,7))";
        TreeNode root = TreeNode.create(str);
        System.out.println(new LeetCode110().isBalanced(root));
    }

}
