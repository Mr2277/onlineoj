package com.huawei.leetcode.interview;

import java.util.*;

public class Problem0408 {

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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DLR(root, p, q);
        return parent;
    }

    private static TreeNode parent = null;

    public static List<TreeNode> DLR(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            List<TreeNode> includes = new ArrayList<>();
            if (root == p || root == q) {
                includes.add(root);
            }
            List<TreeNode> leftIncludes = DLR(root.left, p, q);
            List<TreeNode> rightIncludes = DLR(root.right, p, q);
            int leftSize = leftIncludes == null ? 0 : leftIncludes.size();
            int rightSize = rightIncludes == null ? 0 : rightIncludes.size();
            if (includes.size() + leftSize + rightSize == 2 && parent == null) {
                parent = root;
            }
            if (leftIncludes != null && !leftIncludes.isEmpty()) {
                includes.addAll(leftIncludes);
            }
            if (rightIncludes != null && !rightIncludes.isEmpty()) {
                includes.addAll(rightIncludes);
            }
            return includes;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            TreeNode parent = lowestCommonAncestor(root, root.left, root.right);
            System.out.println(parent.val);
        }
    }
}
