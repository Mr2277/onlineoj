package com.huawei.leetcode.leetcode101_110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode103 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode createTree(int[] nums) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nodes.isEmpty()) {
                TreeNode node = new TreeNode(nums[i]);
                node.left = null;
                node.right = null;
            } else {
                int parent = (i & 1) == 1 ? i / 2 : (i - 1) / 2;
                boolean isLeft = (i & 1) == 1 ? true : false;
                TreeNode parentNode = nodes.get(parent);
                if (parentNode == null) {
                    int index = parent + 1;
                    while (parentNode == null) {
                        parentNode = nodes.get(index++);
                    }
                }
                TreeNode node = new TreeNode(nums[i]);
                node.left = null;
                node.right = null;
                if (isLeft) {
                    parentNode.left = node;
                } else {
                    parentNode.right = node;
                }
            }
        }
        return null;
    }

    public static void create(String str) {
        int index = 0;
        char ch = str.charAt(index);
        String cur = "", pre = "", next = "";
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode parent = null, node = null;
        while (index < str.length()) {
            while (ch >= '0' && ch <= '9') {
                cur += ch;
                index++;
                ch = str.charAt(index);
            }
            next = String.valueOf(ch);
            if (!"".equals(cur)) {
                Integer curVal = Integer.valueOf(cur);
                node = new TreeNode(curVal);
                node.left = null;
                node.right = null;
            }
            switch (pre) {

                case "(":
                    parent = treeNodeStack.peek();
                    parent.left = node;
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ",":
                    parent = treeNodeStack.peek();
                    parent.right = node;
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ")":
                    treeNodeStack.pop();
                    break;
                default:
                    if(next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
            }
            pre = "".equals(cur) ? String.valueOf(str.charAt(index)) : next;
            cur = "";
            index++;
            ch = index < str.length() ? str.charAt(index) : ')';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            /*
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            */
            String str = scanner.nextLine();
            create(str);
        }
    }
}
