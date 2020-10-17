package com.huawei.leetcode.leetcode1_1000.leetcode601_700.leetcode601_610;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode606 {

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

    public static String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        builder = preOrder(t, builder, 1);
        return builder.toString();
    }

    public static StringBuilder preOrder(TreeNode root, StringBuilder builder, int level) {
        if (root == null) {
            //builder.append("(");
            return builder;
        } else {
            if (level == 1) {
                builder.append(root.val);
            } else {
                builder.append("(");
                builder.append(root.val);
                //builder.append(")");
            }
            if (root.left != null) {
                preOrder(root.left, builder, level + 1);
                builder.append(")");
            } else if (root.right != null) {
                builder.append("()");
            }
            if (root.right != null) {
                preOrder(root.right, builder, level + 1);
                builder.append(")");
            }
            return builder;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            System.out.println(tree2str(root));
        }
    }
}
