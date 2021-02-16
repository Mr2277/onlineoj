package com.huawei.kexin.leetcodedfs;

import java.util.Stack;

public class LeetCode513 {

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

    public int maxDeepth = 0;

    public TreeNode left = null;

    public int findBottomLeftValue(TreeNode root) {
        if (root.right == null && root.left == null) {
            return root.val;
        }
        dfs(root, 1);
        return left.val;
    }

    public void dfs (TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (level > maxDeepth) {
                maxDeepth = level;
                left = root.left;
            }
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            if (level > maxDeepth) {
                maxDeepth = level;
                left = root.right;
            }
            dfs(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        String str = "1(2(4,#),3(5,6(9,#)))";
        TreeNode root = create(str);
        System.out.println(new LeetCode513().findBottomLeftValue(root));
    }
}
