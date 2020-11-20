package com.huawei.leetcode.leetcode1_1000.leetcode301_400.leetcode331_340;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode337 {

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

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int pickCur = root.val;
        if (root.left != null) {
            pickCur += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            pickCur += rob(root.right.left) + rob(root.right.right);
        }
        int pickChild = rob(root.left) + rob(root.right);
        return pickCur > pickChild ? pickCur : pickChild;
    }

    public static void main(String[] args) {
        String str = "3(2(#,3),3(#,1))";
        TreeNode root = create(str);
        System.out.println(rob(root));
    }
}
