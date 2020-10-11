package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode111_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        result = DFS(root, sum, result, subResult);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        return result;
    }

    public static List<List<Integer>> DFS(TreeNode node, int sum, List<List<Integer>> result, List<Integer> subResult) {
        if (node == null) {
            return result;
        } else if (node.left == null && node.right == null) {
            if (node.val == sum) {
                List<Integer> list = new ArrayList<>(subResult);
                list.add(node.val);
                result.add(list);
            }
            return result;
        } else {
            subResult.add(node.val);
            DFS(node.left, sum - node.val, result, subResult);
            DFS(node.right, sum - node.val, result, subResult);
            subResult.remove(subResult.size() - 1);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            int sum = scanner.nextInt();
            pathSum(root, sum);
        }
    }
}
