package com.huawei.leetcode.leetcode1001_2000.leetcode1501_1600.leetcode1521_1530;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode1530 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static int countPairs(TreeNode root, int distance) {
        List<TreeNode> path = new ArrayList<>();
        List<List<TreeNode>> allPath = new ArrayList<>();
        allPath = findPath(root, path, allPath);
        /*
        for (List<TreeNode> list : allPath) {
            for (TreeNode integer : list) {
                System.out.print(integer + "#" + integer.val + " ");
            }
            System.out.println();
        }
        */

        int count = 0;
        for (int i = 0; i < allPath.size(); i++) {
            List<TreeNode> listI = allPath.get(i);
            for (int j = i + 1; j < allPath.size(); j++) {
                List<TreeNode> listJ = allPath.get(j);
                int k = 0;
                int length = Integer.min(listI.size(), listJ.size());
                for (k = 0; k < length; k++) {
                    if (listI.get(k) != listJ.get(k)) {
                        break;
                    }
                }
                int dis = listI.size() - k + listJ.size() - k;
                count = dis <= distance ? count + 1 : count;
            }
        }

        return count;
    }

    public static List<List<TreeNode>> findPath(TreeNode root, List<TreeNode> path, List<List<TreeNode>> allPath) {
        if (root == null) {
            return allPath;
        } else if (root.left == null && root.right == null) {
            List<TreeNode> copyPath = new ArrayList<>(path);
            copyPath.add(root);
            allPath.add(copyPath);
            return allPath;
        } else {
            path.add(root);
            findPath(root.left, path, allPath);
            findPath(root.right, path, allPath);
            path.remove(path.size() - 1);
            return allPath;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            int dis = scanner.nextInt();
            System.out.println(countPairs(root, dis));
        }
    }
}
