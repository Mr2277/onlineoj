package com.huawei.leetcode.leetcode1001_2000.leetcode1001_1100.leetcode1021_1030;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode1022 {

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

    public static int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        list = allPath(root, builder, list);
        int sum = 0;
        for (String str : list) {
            //BigInteger bigInteger = new BigInteger(str, 2);
            Integer integer = Integer.valueOf(str, 2);
            sum += integer.intValue();
        }
        return sum;
    }

    public static List<String> allPath(TreeNode root, StringBuilder builder, List<String> paths) {
        if (root == null) {
            return paths;
        } else if (root.left == null && root.right == null){
            builder.append(root.val);
            paths.add(builder.toString());
            builder.deleteCharAt(builder.length() - 1);
            return paths;
        } else {
            builder.append(root.val);
            allPath(root.left, builder, paths);
            allPath(root.right, builder, paths);
            builder.deleteCharAt(builder.length() - 1);
            return paths;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            sumRootToLeaf(root);
        }
    }
}
