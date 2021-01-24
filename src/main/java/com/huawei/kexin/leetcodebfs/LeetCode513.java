package com.huawei.kexin.leetcodebfs;

import java.util.LinkedList;
import java.util.Queue;
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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lastLeftVal = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFind = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    if (!isFind) {
                        lastLeftVal = cur.left.val;
                        isFind = true;
                    }
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    if (!isFind) {
                        lastLeftVal = cur.right.val;
                        isFind = true;
                    }
                    queue.add(cur.right);
                }
            }
        }
        return lastLeftVal;
    }

    public static void main(String[] args) {
        //String str = "1(2(4,#),3(5(7,#),6))";
        String str = "1(#,0)";
        TreeNode root = create(str);
        System.out.println(new LeetCode513().findBottomLeftValue(root));
    }
}
