package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode561_570;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode563 {

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

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            List<Integer> nodes = new ArrayList<>();
            dfs(root.left, nodes);
            for (Integer integer : nodes) {
                left += integer;
            }
        }
        if (root.right != null) {
            right = root.right.val;
            //List<Integer> nodes = new A
        }
        int sum = Math.abs(left - right);
        return sum + findTilt(root.left) + findTilt(root.right);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return nodes;
        }
        nodes.add(root.val);
        dfs(root.left, nodes);
        dfs(root.right, nodes);
        return nodes;
    }

    public static void main(String[] args) {
        String str = "4(2(3,5),9(#,7))";
        TreeNode root = create(str);
        new LeetCode563().findTilt(root);
        //int a = 2;
        //int b = 3;
        //System.out.println(Math.abs(a - b));
    }
}
