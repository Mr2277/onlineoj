package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode871_880;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode872 {

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

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> path1 = new ArrayList<>();
        DLR(root1, path1);
        List<Integer> path2= new ArrayList<>();
        DLR(root2, path2);
        StringBuilder builder1 = new StringBuilder();
        for (Integer integer : path1) {
            builder1.append('\'');
            builder1.append(integer);
            builder1.append('\'');
        }
        //System.out.println(builder1.toString());
        StringBuilder builder2 = new StringBuilder();
        for (Integer integer : path2) {
            builder2.append('\'');
            builder2.append(integer);
            builder2.append('\'');
        }
        return builder1.toString().equals(builder2.toString()) ? true : false;
    }

    public static List<Integer> DLR(TreeNode root, List<Integer> path) {
        if (root == null) {
            return null;
        }
        DLR(root.left, path);
        DLR(root.right, path);
        if (root.left == null && root.right == null) {
            path.add(root.val);
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            leafSimilar(root, null);
        }
    }
}
