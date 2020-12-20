package com.huawei.leetcode.leetcode1001_2000.leetcode1601_1700.leetcode1161_1170;

import java.util.*;

public class LeetCode1161 {
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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        paths.add(path);
        while (!queue.isEmpty()) {
            int size = queue.size();
            path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    path.add(cur.left.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    path.add(cur.right.val);
                }
            }
            if (!path.isEmpty()) {
                paths.add(path);
            }
        }
        int max = Integer.MIN_VALUE;
        int level = 1;
        int maxLevel = 1;
        for (List<Integer> list : paths) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        String str = "1(7(2,3),0)";
        TreeNode root = create(str);
        new LeetCode1161().maxLevelSum(root);
    }
}
