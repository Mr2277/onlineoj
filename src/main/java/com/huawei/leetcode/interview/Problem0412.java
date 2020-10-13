package com.huawei.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem0412 {

    private int ret = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    /*
    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return ret;
    }
    */
    /**
     * 从root结点出发，求路径和等于sum路径数
     *
     * @param root
     * @param sum
     */
    /*
    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            ret++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
    */
    /**
     * 题目要求可以从每个结点出发，每个结点调用一次dfs
     *
     * @param root
     * @param sum
     */
    /*
    private void preOrder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        dfs(root, sum);
        preOrder(root.left, sum);
        preOrder(root.right, sum);
    }
    */

    public static int pathSum(TreeNode root, int sum) {
        List<Integer> subResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, 0, subResult, result);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return result.size() + left + right;
    }

    public static int dfs(TreeNode root, int sum, int current, List<Integer> subResult, List<List<Integer>> result) {
        if (root == null) {
            return current;
        } else {
            current += root.val;
            subResult.add(root.val);
            if (sum == current) {
                List<Integer> copySubResult = new ArrayList<>(subResult);
                result.add(copySubResult);
            }
            dfs(root.left, sum, current, subResult, result);
            dfs(root.right, sum, current, subResult, result);
            current -= root.val;
            subResult.remove(subResult.size() - 1);
            return result.size();
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
