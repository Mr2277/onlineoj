package com.huawei.leetcode.leetcode1_1000.leetcode401_500.leetcode401_410;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode404 {

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

    public static int sumOfLeftLeaves(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        nodes = leftNodes(root, nodes, true);
        int sum = 0;
        for (Integer integer : nodes) {
            //System.out.print(integer + " ");
            sum += integer;
        }
        //System.out.println();
        return nodes.size() <= 1 ? 0 : sum;
    }

    public static List<Integer> leftNodes(TreeNode node, List<Integer> nodes, boolean isLeft) {
        if (node == null) {
            return nodes;
        } else if (node.left == null && node.right == null && isLeft) {
            nodes.add(node.val);
            return nodes;
        } else {
            if (node.left != null) {
                leftNodes(node.left, nodes, true);
            }
            if (node.right != null) {
                leftNodes(node.right, nodes, false);
            }
            return nodes;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            System.out.println(sumOfLeftLeaves(root));
        }
    }
}
