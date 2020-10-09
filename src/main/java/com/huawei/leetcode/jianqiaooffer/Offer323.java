package com.huawei.leetcode.jianqiaooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Offer323 {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            boolean isFromLeftToRight = true;
            Stack<TreeNode> treeNodeStack = new Stack<>();
            treeNodeStack.add(root);
            while (!treeNodeStack.isEmpty()) {
                int size = treeNodeStack.size();
                List<Integer> subResult = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = treeNodeStack.pop();
                    subResult.add(node.val);
                    if (isFromLeftToRight) {
                        if (node.left != null) {
                            treeNodeStack.add(node.left);
                        }
                        if (node.right != null) {
                            treeNodeStack.add(node.right);
                        }
                    }
                    else {
                        if (node.right != null) {
                            treeNodeStack.add(node.right);
                        }
                        if (node.left != null) {
                            treeNodeStack.add(node.left);
                        }
                    }
                }
                result.add(subResult);
                isFromLeftToRight = isFromLeftToRight == true ? false : true;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            levelOrder(root);
        }
    }
}
