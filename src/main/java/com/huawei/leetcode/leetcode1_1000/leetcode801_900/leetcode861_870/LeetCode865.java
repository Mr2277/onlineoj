package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode861_870;

import com.huawei.kexin.util.TreeNode;

public class LeetCode865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        dfs(root, 0);
        return node;
    }

    public int max = 0;

    public TreeNode node;

    public void dfs(TreeNode root, int deepth) {
        if (root == null) {
            return;
        }
        if (deepth > max) {
            if (root.left != null || root.right != null) {
                max = deepth;
                node = root;
            }
        }
        dfs(root.left, deepth + 1);
        dfs(root.right, deepth + 1);
    }

    public static void main(String[] args) {
        //String str = "3(5(6,2(7,4)),1(0,8))";
        String str = "0(1,3(#,2))";
        TreeNode root = TreeNode.create(str);
        LeetCode865 leetCode865 = new LeetCode865();
        System.out.println(leetCode865.subtreeWithAllDeepest(root).val);
    }
}
