package com.huawei.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem0406 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
    /*
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> path = new ArrayList<>();
        path = LDR(root, path);
        TreeNode target = null;
        for (int i  = 0; i < path.size(); i++) {
            if (p == path.get(i)) {
                target = i == path.size() - 1 ? null : path.get(i + 1);
            }
        }
        return target;
    }

    public static List<TreeNode> LDR(TreeNode root, List<TreeNode> path) {
        if (root == null) {
            return path;
        }
        LDR(root.left, path);
        path.add(root);
        LDR(root.right, path);
        return path;
    }
    */
    public static TreeNode target = null;

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        if (root == p) {
            target = root.right;
        }
        if (root.left != null) {
            if (root.left == p) {
                target = root;
            } else {
                inorderSuccessor(root.left, p);
            }
        }
        if (root.right != null) {
            if (root.right == p) {
                target = root.right.right;
            } else {
                inorderSuccessor(root.right, p);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            inorderSuccessor(root, root.left.right);
        }
    }
}
