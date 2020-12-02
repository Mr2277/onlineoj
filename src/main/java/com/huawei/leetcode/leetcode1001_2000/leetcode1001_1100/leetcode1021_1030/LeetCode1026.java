package com.huawei.leetcode.leetcode1001_2000.leetcode1001_1100.leetcode1021_1030;

import java.util.Stack;

public class LeetCode1026 {

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
    public static int result = 0;

    public static int maxAncestorDiff(TreeNode root) {
        dfs(root, root);
        if (root.left != null) {
            maxAncestorDiff(root.left);
        }
        if (root.right != null) {
            maxAncestorDiff(root.right);
        }
        return result;
    }

    public static void dfs(TreeNode node, TreeNode root) {
        if (node == null) {
            return;
        }
        int abs = 0;
        if (node.left != null) {
            abs = Math.abs(root.val - node.left.val);
            if (abs > result) {
                result = abs;
            }
            dfs(node.left, root);
        }
        if (node.right != null) {
            abs = Math.abs(root.val - node.right.val);
            if (abs > result) {
                result = abs;
            }
            dfs(node.right, root);
        }
    }

    public static void main(String[] args) {
        //String str = "8(3(1,6(4,7)),10(#,14(13,#)))";
        String str = "1(#,2(#,0(3,#)))";
        TreeNode root = create(str);
        System.out.println(maxAncestorDiff(root));
    }
}
