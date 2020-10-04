package com.huawei.leetcode.leetcode101_110;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode108 {

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

    public static TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null : DFS(nums,0, nums.length - 1);
    }

    public static TreeNode DFS(int[] nums, int start, int end) {
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            node.left = null;
            node.right = null;
            return node;
        } else if (start > end) {
            return null;
        } else {
            int length = end - start;
            int mid = (length & 1) == 1 ? (end + start + 1) / 2 : (start + end) /2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = DFS(nums, start, mid - 1);
            node.right = DFS(nums, mid + 1, end);
            return node;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            sortedArrayToBST(nums);
        }
    }
}
