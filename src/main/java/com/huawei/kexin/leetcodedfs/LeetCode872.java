package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;
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
    /*
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> path1 = new ArrayList<>();
        dfs(root1, path1);
        List<Integer> path2 = new ArrayList<>();
        dfs(root2, path2);
        boolean result = true;
        if (path1.size() != path2.size()) {
            return false;
        } else {
            for (int i = 0; i < path1.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> dfs(TreeNode root, List<Integer> paths) {
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add(root.val);
        }
        dfs(root.left, paths);
        dfs(root.right, paths);
        return paths;
    }
    */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> path1 = new ArrayList<>();
        DLR(root1, path1);
        List<Integer> path2= new ArrayList<>();
        DLR(root2, path2);
        StringBuilder builder1 = new StringBuilder();
        for (Integer integer : path1) {
            builder1.append(integer);
        }
        StringBuilder builder2 = new StringBuilder();
        for (Integer integer : path2) {
            builder2.append(integer);
        }
        System.out.println(builder1.toString());
        System.out.println(builder2.toString());
        return builder1.toString().equals(builder2.toString()) ? true : false;
    }

    public List<Integer> DLR(TreeNode root, List<Integer> path) {
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
        String str1 = "3(5(6,2(7,4)),1(9,8))";
        String str2 = "3(5(6,7),1(4,2(9,8)))";
        TreeNode root1 = create(str1);
        TreeNode root2 = create(str2);
        System.out.println(new LeetCode872().leafSimilar(root1, root2));
    }
}
