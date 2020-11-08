package com.huawei.leetcode.jianqiaooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Offer34 {

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

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        DFS(root, sum, path, paths);
        return paths;
    }

    public static List<List<Integer>> DFS(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> copyPath = new ArrayList<>(path);
            copyPath.add(root.val);
            paths.add(copyPath);
            return paths;
        }
        path.add(root.val);
        DFS(root.left, sum - root.val, path, paths);
        DFS(root.right, sum - root.val, path, paths);
        path.remove(path.size() - 1);
        return paths;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
            //String str = scanner.nextLine();
            String str = "5(4(11(7,2),#),8(13,4(5,1)))";
            TreeNode root = create(str);
            int sum = 22;
            pathSum(root, sum);

    }
}
