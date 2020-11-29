package com.huawei.leetcode.leetcode1001_2000.leetcode1101_1200.leetcode1121_1130;

import java.util.Stack;

public class LeetCode1123 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode create(String str) {
        int index = 0;
        char ch = str.charAt(index);
        String cur = "", pre = "", next = "";
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode parent = null, node = null;
        while (index < str.length()) {
            while (ch >= '0' && ch <= '9' || ch == '#') {
                cur += ch;
                index++;
                ch = str.charAt(index);
            }
            next = String.valueOf(ch);
            if (!"".equals(cur) && !cur.equals("#")) {
                Integer curVal = Integer.valueOf(cur);
                node = new TreeNode(curVal);
                node.left = null;
                node.right = null;
            }
            switch (pre) {

                case "(":
                    parent = treeNodeStack.peek();
                    if (!cur.equals("#")) {
                        parent.left = node;
                    }
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ",":
                    parent = treeNodeStack.peek();
                    if (!cur.equals("#")) {
                        parent.right = node;
                    }
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ")":
                    treeNodeStack.pop();
                    break;
                default:
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
            }

            pre = "".equals(cur) ? String.valueOf(str.charAt(index)) : next;
            cur = "";
            index++;
            ch = index < str.length() ? str.charAt(index) : ')';
        }
        return treeNodeStack.peek();
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = max(root.left);
        int right = max(root.right);
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        }
        if (right > left) {
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }

    public static int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = max(node.left) + 1;
        int right = max(node.right) + 1;
        return Integer.max(left, right);
    }

    public static void main(String[] args) {
        String str = "3(5(6,2(7,4)),1(0,8))";
        TreeNode root = create(str);
        System.out.println(lcaDeepestLeaves(root).val);
    }
}
