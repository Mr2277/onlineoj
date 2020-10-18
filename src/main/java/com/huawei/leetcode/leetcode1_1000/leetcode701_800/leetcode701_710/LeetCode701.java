package com.huawei.leetcode.leetcode1_1000.leetcode701_800.leetcode701_710;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode701 {

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

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            node.left = null;
            node.right = null;
            return node;
        } else {
            return createTree(root, val);
        }
    }

    public static TreeNode createTree(TreeNode root, int val) {
        if (root == null) {
            return root;
        } else {
            if (root.val < val) {
                TreeNode right = createTree(root.right, val);
                if (right == null) {
                    TreeNode node = new TreeNode(val);
                    node.right = null;
                    node.left = null;
                    root.right = node;
                }
            } else {
                TreeNode left = createTree(root.left, val);
                if (left == null) {
                    TreeNode node = new TreeNode(val);
                    node.left = null;
                    node.right = null;
                    root.left = node;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            //System.out.println(isValidBST(root));
            int val = scanner.nextInt();
            insertIntoBST(root, val);
        }
    }
}
