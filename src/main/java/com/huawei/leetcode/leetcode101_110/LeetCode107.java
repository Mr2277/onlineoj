package com.huawei.leetcode.leetcode101_110;

import java.util.*;

public class LeetCode107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            treeNodeQueue.add(root);
            while (!treeNodeQueue.isEmpty()) {
                int size = treeNodeQueue.size();
                List<Integer> subResult = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = treeNodeQueue.poll();
                    subResult.add(node.val);
                    if (node.left != null) {
                        treeNodeQueue.add(node.left);
                    }
                    if (node.right != null) {
                        treeNodeQueue.add(node.right);
                    }
                }
                result.add(subResult);
            }
        }
        List<List<Integer>> reserveResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reserveResult.add(result.get(i));
        }
        return reserveResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
        }
    }
}
