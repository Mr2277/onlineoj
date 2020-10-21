package com.huawei.leetcode.leetcode1001_2000.leetcode1301_1400.leetcode1311_1320;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode1315 {

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

    public static int sumEvenGrandparent(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        DFS(root, nodes);
        int sum = 0;
        for (Integer integer : nodes) {
            sum += integer;
        }
        return sum;
    }

    public static List<Integer> DFS(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return nodes;
        } else {
            if ((root.val & 1) != 1) {
                TreeNode leftNode = root.left;
                TreeNode rightNode = root.right;
                if (leftNode != null) {
                    TreeNode grandLeftNode = leftNode.left;
                    TreeNode grandRightNode = leftNode.right;
                    if (grandLeftNode != null) {
                        nodes.add(grandLeftNode.val);
                    }
                    if (grandRightNode != null) {
                        nodes.add(grandRightNode.val);
                    }
                }
                if (rightNode != null) {
                    TreeNode grandLeftNode = rightNode.left;
                    TreeNode grandRightNode = rightNode.right;
                    if (grandLeftNode != null) {
                        nodes.add(grandLeftNode.val);
                    }
                    if (grandRightNode != null) {
                        nodes.add(grandRightNode.val);
                    }
                }
            }
            DFS(root.left, nodes);
            DFS(root.right, nodes);
            return nodes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            System.out.println(sumEvenGrandparent(root));
        }
        /*
        int n = 2;
        System.out.println(n & 1);
        n = 3;
        System.out.println(n & 1);
        */
    }
}
