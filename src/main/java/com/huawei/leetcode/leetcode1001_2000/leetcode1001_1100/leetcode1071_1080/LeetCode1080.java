package com.huawei.leetcode.leetcode1001_2000.leetcode1001_1100.leetcode1071_1080;

import java.util.*;

public class LeetCode1080 {

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

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return root;
        }
        root = DLR(root, limit);
        if (root != null) {
            root.left = sufficientSubset(root.left, limit);
            root.right = sufficientSubset(root.right, limit);
        }
        return root;
    }

    public static TreeNode DLR(TreeNode root, int limit) {
        if (root == null) {
            return root;
        }
        root.left = DLR(root.left, limit - root.val);
        root.right = DLR(root.right, limit - root.val);
        if (root.left == null && root.right == null) {
            return root.val >= limit ? root : null;
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "5(6(8(9,10),3(2,1)),7(3(1,2),6(13,14)))";
        TreeNode root = create(str);
        sufficientSubset(root, 6);
    }

}
