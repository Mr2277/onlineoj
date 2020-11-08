package com.huawei.leetcode.leetcode1001_2000.leetcode1001_1100.leetcode1071_1080;

import java.util.*;

public class LeetCode1080 {

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

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return root;
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        DLR(path, paths, root);
        boolean isDelete = true;
        for (List<Integer> list : paths) {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum >= limit) {
                isDelete = false;
                break;
            }
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right ,limit);
        return isDelete ? null : root;

    }

    public static List<List<Integer>> DLR(List<Integer> path, List<List<Integer>> paths, TreeNode root) {
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(root.val);
            paths.add(copyPath);
            return paths;
        }
        path.add(root.val);
        DLR(path, paths, root.left);
        DLR(path, paths, root.right);
        path.remove(path.size() - 1);
        return paths;
    }

    public static void main(String[] args) {
        String str = "5(4,8)";
        TreeNode root = create(str);
        sufficientSubset(root, 7);
    }

}
