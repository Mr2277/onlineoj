package com.huawei.leetcode.leetcode1_1000.leetcode101_200.leetcode111_120;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode111 {

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
    /*
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if ((root.left == null && root != null && root.right != null)
                || (root.right == null && root != null && root.left != null)) {
            return 2;
        } else if (root != null && root.right == null && root.left == null) {
            return 1;
        } else {
            int left = DFS(root.left, 2);
            int right = DFS(root.right, 2);

            return Integer.min(left, right);
        }
    }
    */
    /*
    public static int DFS(TreeNode node, int depth) {
        if (node == null) {
            return depth - 1;
        } else {
            int depthLeft = DFS(node.left, depth + 1);
            int depthRight = DFS(node.right, depth + 1);
            return Integer.max(depthLeft, depthRight);
        }
    }
    */
    /*
    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if(root.left != null) {
            ans = Math.min(minDepth(root.left), ans);
        }
        if(root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;
    }
    */

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        //左子树的最小深度
        int left = minDepth(root.left);
        //右子树的最小深度
        int right = minDepth(root.right);
        //如果left和right都为0，我们返回1即可，
        //如果left和right只有一个为0，说明他只有一个子结点，我们只需要返回它另一个子节点的最小深度+1即可。
        //如果left和right都不为0，说明他有两个子节点，我们只需要返回最小深度的+1即可。
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /*
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? (left + right) + 1;
        return left + 1;
    }
    */
    /*
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int depth = Integer.MIN_VALUE;
            if (root.left != null) {
                depth = Integer.max(maxDepth(root.left), depth);
            }
            if (root.right != null) {
                depth = Integer.max(maxDepth(root.right), depth);
            }
            return depth + 1;
        }
    }
    */
    /*
    public static int maxDepth(TreeNode node) {
        return DFS(node, 1);
    }

    public static int DFS(TreeNode node, int level) {
        if (node == null) {
            return level - 1;
        } else {
            int left = DFS(node.left, level + 1);
            int right = DFS(node.right, level + 1);
            return Integer.max(left, right);
        }
    }
    */

    public static int minDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = minDeep(root.left);
        int rightDeep = minDeep(root.right);
        return (leftDeep == 0 || rightDeep == 0) ? leftDeep + rightDeep + 1 : Integer.min(leftDeep, rightDeep) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            //System.out.println(minDepth(root));
            //minDepth(root);
            System.out.println(minDeep(root));
        }
    }
}
