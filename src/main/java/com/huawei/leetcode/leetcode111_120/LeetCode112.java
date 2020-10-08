package com.huawei.leetcode.leetcode111_120;

import java.util.*;

public class LeetCode112 {

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
    public static boolean hasPathSum(TreeNode root, int sum) {
        Set<Integer> result = new HashSet<>();
        result = DFS(root, 0, result);
        return result.contains(sum) ? true : false;
    }

    public static Set<Integer> DFS(TreeNode node, int pathSum, Set<Integer> result) {
        if (node == null) {
            return result;
        } else if (node != null && node.left == null && node.right == null) {
            pathSum += node.val;
            result.add(pathSum);
            return result;
        } else {
            pathSum += node.val;
            if (node.left != null) {
                result = DFS(node.left, pathSum, result);
            }
            if (node.right != null) {
                result = DFS(node.right, pathSum, result);
            }
            pathSum -= node.val;
            return result;
        }
    }
    */

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            int sum = scanner.nextInt();
            hasPathSum(root, sum);
        }
    }
}
