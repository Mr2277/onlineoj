package com.huawei.kexin.leetcodebfs;

import javax.xml.namespace.QName;
import java.util.*;

public class LeetCode101 {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean result = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    list.add(String.valueOf(cur.left.val));
                    queue.add(cur.left);
                } else {
                    list.add("#");
                }
                if (cur.right != null) {
                    list.add(String.valueOf(cur.right.val));
                    queue.add(cur.right);
                } else {
                    list.add("#");
                }
            }
            for (int j = 0; j <list.size(); j++) {
                String left = list.get(j);
                String right = list.get(list.size() - 1 - j);
                if (!left.equals(right)) {
                    result = false;
                    queue.clear();
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1(2(3,4),2(4,3))";
        TreeNode root = create(str);
        System.out.println(new LeetCode101().isSymmetric(root));
    }
}
