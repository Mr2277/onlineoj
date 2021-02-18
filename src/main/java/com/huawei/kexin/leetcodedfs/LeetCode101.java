package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        String str = "1(2(3,4),2(4,3))";
        TreeNode root = TreeNode.create(str);
        System.out.println(new LeetCode101().isSymmetric(root));
    }
}
