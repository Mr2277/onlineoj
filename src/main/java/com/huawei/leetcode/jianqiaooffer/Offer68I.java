package com.huawei.leetcode.jianqiaooffer;

import java.util.*;

public class Offer68I {

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
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        pList = findPath(root, p, pList);
        List<TreeNode> qList = new ArrayList<>();
        qList = findPath(root, q, qList);

        int size = Integer.min(qList.size(), pList.size());
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            if (pList.get(i) == qList.get(i) && pList.get(i + 1) != qList.get(i + 1)) {
                break;
            }
        }
        return qList.get(i);
    }

    public static List<TreeNode> findPath(TreeNode root, TreeNode target, List<TreeNode> paths) {
        if (root == null) {
            return null;
        } else if (root == target) {
            List<TreeNode> copyPath = new ArrayList<>(paths);
            copyPath.add(root);
            return copyPath;
        } else {
            paths.add(root);
            List<TreeNode> leftPath = findPath(root.left, target, paths);
            List<TreeNode> rightPath = findPath(root.right, target, paths);
            paths.remove(paths.size() - 1);
            return leftPath == null ? rightPath : leftPath;
        }
    }
    */
    //public static Set<TreeNode> set = new HashSet<>();

    //public static Queue<TreeNode> queue = new LinkedList<>();

    //ublic static Map<TreeNode, Integer> map = new LinkedHashMap<>();

    public static List<TreeNode> list = new ArrayList<>();

    public static TreeNode findParent(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> includes = new ArrayList<>();
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            includes.add(root);
        }
        TreeNode left = findParent(root.left, p, q);
        TreeNode right = findParent(root.right, p, q);
        if (left != null) {
            includes.add(left);
        }
        if (right != null) {
            includes.add(right);
        }
        if (includes.size() == 2) {
            list.add(root);
        }
        return includes.isEmpty() ? null : includes.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            //lowestCommonAncestor(root, root.left.left, root.right.right);
            findParent(root, root.left, root.left.right);
        }
    }
}
