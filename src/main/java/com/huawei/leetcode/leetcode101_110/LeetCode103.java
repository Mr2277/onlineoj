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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            boolean isFromLefttoRight = false;
            List<Integer> subResult = new ArrayList<>();
            subResult.add(root.val);
            result.add(subResult);
            Stack<TreeNode> treeNodeStack = new Stack<>();
            treeNodeStack.add(root);
            while (!treeNodeStack.isEmpty()) {
                int size = treeNodeStack.size();
                subResult = new ArrayList<>();
                List<TreeNode> nodes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = treeNodeStack.pop();
                    if (isFromLefttoRight) {
                        if (node.left != null) {
                            subResult.add(node.left.val);
                            // treeNodeStack.add(node.left);
                            nodes.add(node.left);
                        }
                        if (node.right != null) {
                            subResult.add(node.right.val);
                            // treeNodeStack.add(node.right);
                            nodes.add(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            subResult.add(node.right.val);
                            // treeNodeStack.add(node.right);
                            nodes.add(node.right);
                        }
                        if (node.left != null) {
                            subResult.add(node.left.val);
                            // treeNodeStack.add(node.left);
                            nodes.add(node.left);
                        }
                    }
                }
                if (!subResult.isEmpty()) {
                    result.add(subResult);
                }
                for (TreeNode node : nodes) {
                    treeNodeStack.add(node);
                }
                isFromLefttoRight = isFromLefttoRight == false ? true : false;
            }
        }
        return result;
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
            // 1(2(4,#),3(#,5))
            String str = scanner.nextLine();
            TreeNode root = create(str);
            List<List<Integer>> lists = zigzagLevelOrder(root);
            for (List<Integer> list : lists) {
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
    }
}
