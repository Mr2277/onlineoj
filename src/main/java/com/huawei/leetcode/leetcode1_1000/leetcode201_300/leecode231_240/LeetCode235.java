package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leecode231_240;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode235 {

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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        pPath = findPath(root, p, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        qPath = findPath(root, q, qPath);
        int size = Integer.min(pPath.size(), qPath.size());
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            if (qPath.get(i) == pPath.get(i) && qPath.get(i + 1) != pPath.get(i + 1)) {
                break;
            }
        }
        return qPath.get(i);
    }

    public static List<TreeNode> findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return path;
        } else if(root == target) {
             List<TreeNode> resultCopy = new ArrayList<>(path);
             if (resultCopy.isEmpty()) {
                 resultCopy.add(root);
             }
             return resultCopy;
        } else {
            path.add(root);
            List<TreeNode> left = null;
            List<TreeNode> right = null;
            if (root.left != null) {
                path.add(root.left);
                left = findPath(root.left, target, path);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                path.add(root.right);
                right = findPath(root.right, target, path);
                path.remove(path.size() - 1);
            }
            path.remove(path.size() - 1);
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            lowestCommonAncestor(root, root, root.left);
        }
    }
}
