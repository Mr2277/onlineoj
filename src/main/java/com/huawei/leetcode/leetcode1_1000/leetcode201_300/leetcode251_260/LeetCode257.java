package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode251_260;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode257 {

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

    public static List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        DLR(root, path, paths);
        List<String> result = new ArrayList<>();
        for (List<Integer> list : paths) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    str += String.valueOf(list.get(i)) + "->";
                } else {
                    str += String.valueOf(list.get(i));
                }
            }
            result.add(str);
            str = "";
        }
        return result;
    }

    public static List<List<Integer>> DLR(TreeNode root, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return paths;
        } else if (root.left == null && root.right == null) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(root.val);
            paths.add(copyPath);
            return paths;
        } else {
            path.add(root.val);
            DLR(root.left, path, paths);
            DLR(root.right, path, paths);
            path.remove(path.size() - 1);
        }
        return paths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            List<String> list = binaryTreePaths(root);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
