package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode129 {

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
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, "");
            int sum = 0;
            for (String str : list) {
                sum += Integer.parseInt(str);
            }
            return sum;
        }
        public List<String> list = new ArrayList<>();

        public void dfs(TreeNode root, String str) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                str = str + root.val;
                list.add(str);
                return;
            }
            dfs(root.left, str + root.val);
            dfs(root.right, str + root.val);
        }

    public static void main(String[] args) {
        String str = "4(9(5,1),0)";
        TreeNode root = create(str);
        System.out.println(new LeetCode129().sumNumbers(root));
    }
}
