package com.huawei.leetcode.leetcode1001_2000.leetcode1101_1200.leetcode1101_1110;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode1110 {

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



    public static void findDeleteNode(TreeNode root, int target) {
        if (root == null) {
            return;
        } else if (root.val == target) {
            root.val = 0;
            return;
        } else {
            findDeleteNode(root.left, target);
            findDeleteNode(root.right, target);
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        Set<Integer> set = new HashSet<>();
        for (Integer integer : to_delete) {
            set.add(integer);
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        nodes.add(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeQueue.poll();
                if (node.left != null) {
                    treeNodeQueue.add(node.left);
                }
                if (node.right != null) {
                    treeNodeQueue.add(node.right);
                }
                /*
                if (node.val == 0) {
                    if (node.left != null ) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                    node = null;
                }
                */
                if (set.contains(node.val)) {
                    node.val = 0;
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
            }
        }

        for (TreeNode node : nodes) {
            setNodeNull(node);
        }
        nodes = nodes.stream().filter(treeNode -> treeNode.val != 0).collect(Collectors.toList());
        return nodes;
    }

    public static void setNodeNull(TreeNode root) {
        if (root == null) {
            return;
        } else {
            if (root.left != null && root.left.val == 0) {
                root.left = null;
            }
            if (root.right != null && root.right.val == 0) {
                root.right = null;
            }
            if (root.val == 0) {
                root = null;
            }
            if (root != null) {
                setNodeNull(root.left);
                setNodeNull(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            int[] toDelete = new int[] {3,5};
        }
    }
}
