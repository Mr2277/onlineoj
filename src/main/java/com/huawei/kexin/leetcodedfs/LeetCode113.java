package com.huawei.kexin.leetcodedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode113 {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        return dfs(root, list, lists, targetSum);
    }

    public List<List<Integer>> dfs(TreeNode root, List<Integer> list, List<List<Integer>> lists, int target) {
        if (root == null) {
            return lists;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                List<Integer> cpoy = new ArrayList<>(list);
                cpoy.add(root.val);
                lists.add(cpoy);
                return lists;
            }
        }
        list.add(root.val);
        dfs(root.left, list, lists, target - root.val);
        dfs(root.right, list, lists, target - root.val);
        list.remove(list.size() - 1);
        return lists;
    }

    public static void main(String[] args) {
        String str = "5(4(11(7,2),#),8(13,4(5,1)))";
        TreeNode root = create(str);
        List<List<Integer>> lists = new LeetCode113().pathSum(root, 22);
        System.out.println(lists.size());
        System.out.println(lists.size());
    }
}
