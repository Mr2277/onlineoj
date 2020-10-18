package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode521_530;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode530 {

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

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = LDR(root, result);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i + 1) - result.get(i) < min) {
                min = result.get(i + 1) - result.get(i);
            }
        }
        return min;
    }

    public static List<Integer> LDR(TreeNode root, List<Integer> result) {
        if (root == null) {
            return null;
        } else {
            LDR(root.left, result);
            result.add(root.val);
            LDR(root.right, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            //lowestCommonAncestor(root, root.left.left, root.right.right);
            //findParent(root, root.left, root.left.right);
        }
    }
}
