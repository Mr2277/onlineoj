package com.huawei.leetcode.jianqiaooffer;

import java.util.*;

public class Offer32_1 {
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

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int[][] dir = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        List<Integer> paths = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        paths.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    paths.add(cur.left.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    paths.add(cur.right.val);
                }
            }
        }
        int[] intArr = paths.stream().mapToInt(Integer::intValue).toArray();
        return intArr;
    }

    public static void main(String[] args) {
        String str = "3(9,20(15,7))";
        TreeNode root = create(str);
        int[] result = new Offer32_1().levelOrder(root);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
