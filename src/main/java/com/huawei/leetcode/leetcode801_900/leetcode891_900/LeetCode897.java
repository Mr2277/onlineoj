package com.huawei.leetcode.leetcode801_900.leetcode891_900;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode897 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> midOrders = new ArrayList<>();
        midOrders = midOrder(root, midOrders);
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode parent = null;
        for (Integer integer : midOrders) {
            TreeNode node = new TreeNode(integer);
            node.left = null;
            node.right = null;
            if (treeNodeStack.isEmpty()) {
                treeNodeStack.add(node);
                parent = node;
            } else {
                TreeNode topStack = treeNodeStack.peek();
                topStack.right = node;
            }
        }
        return parent;
    }

    public static List<Integer> midOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            midOrder(root.left, result);
            result.add(root.val);
            midOrder(root.right, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

        }
    }
}
