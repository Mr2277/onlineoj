package com.huawei.test;

import java.util.*;

public class TestCreateTree {
    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode(Integer x) { val = x; }
    }
    /*
    public static List<String> pre(TreeNode root, List<String> result) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            result = pre(root.left, result);
            result = pre(root.right, result);
            return result;
        }
    }

    public static List<String> level(TreeNode root, List<String> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                if (queue.peek() != null) {
                    TreeNode curNode = queue.poll();
                    result.add(curNode.val);
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                }
            }
        }
        return result;
    }
    */
    /*
    public static TreeNode createTree(String str) {
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode parent = null;
        String curStr = "";
        for (int i = 0; i < str.length(); i++) {
            curStr = str.charAt(i) >= '0' && str.charAt(i) <= '9' ?
                curStr + String.valueOf(str.charAt(i)) : String.valueOf(str.charAt(i));
            String preStr = i == 0 ? "" : String.valueOf(str.charAt(i - 1));
            String nextStr = i == str.length() - 1 ? "" : String.valueOf(str.charAt(i + 1));
            TreeNode node = new TreeNode(curStr);
            node.left = null;
            node.right = null;
            switch (preStr) {
                case "(":
                          if (nextStr.equals("(")) {
                              parent = treeStack.peek();
                              parent.left = node;
                              treeStack.push(node);
                          }
                          break;
                case ",":
                          if (nextStr.equals("(")) {
                              parent = treeStack.peek();
                              parent.right = node;
                              treeStack.push(node);
                          }
                          break;
                case ")": treeStack.pop();
                          break;
                default:  if (!curStr.equals("(") && !curStr.equals(",") && !curStr.equals(")")) {
                              if (nextStr.equals("(")) {
                                  treeStack.push(node);
                              }
                          }
                          break;

            }
        }
        return treeStack.peek();
    }
    */
    /*
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        boolean isLeftToRight = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!isLeftToRight) {
                    TreeNode node = queue.poll();
                    if (node.right != null) {
                        queue.add(node.right);
                        subResult.add(node.right.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                        subResult.add(node.left.val);
                    }
                }
                if (isLeftToRight) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                        subResult.add(node.left.val);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        subResult.add(node.right.val);
                    }
                }
            }
            isLeftToRight = isLeftToRight == false ? true : false;
        }
        return result;
    }
    */

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        boolean isLeftToRight = false;
        if (root != null) {
            List<Integer> subResult = new ArrayList<>();
            subResult.add(root.val);
            result.add(subResult);
            treeNodeStack.add(root);
        }
        while (!treeNodeStack.isEmpty()) {
            int size = treeNodeStack.size();
            List<Integer> subResult = new ArrayList<>();
            TreeNode node = treeNodeStack.pop();
            for (int i = 0; i < size; i++) {
                if (!isLeftToRight) {
                    if (node.right != null) {
                        subResult.add(node.right.val);
                        treeNodeStack.add(node.right);
                    }
                    if (node.left != null) {
                        subResult.add(node.left.val);
                        treeNodeStack.add(node.left);
                    }
                }
                if (isLeftToRight) {
                    if (node.left != null) {
                        subResult.add(node.left.val);
                        treeNodeStack.add(node.left);
                    }
                    if (node.right != null) {
                        subResult.add(node.right.val);
                        treeNodeStack.add(node);
                    }
                }
            }
        }
        return result;
    }
        public static TreeNode createTree(String str) {
        int index = 0, startIndex = 0;
        String curStr = "", preStr = "", nextStr = "";
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode parent = null;
        while (index < str.length()) {
            char ch = str.charAt(index);
            if (ch >= '0' && ch <= '9') {
                while (true) {
                    index++;
                    ch = str.charAt(index);
                    if (ch == ',' || ch == ')' || ch == '(') {
                        nextStr = String.valueOf(str.charAt(index));
                        break;
                    }

                }
            }
            curStr = str.substring(startIndex, index);
            TreeNode node = null;
            if (!curStr.equals("")) {
                node = new TreeNode(Integer.valueOf(curStr));
                node.left = null;
                node.right = null;
            }
            switch (preStr) {

                case "(":
                    parent = treeNodeStack.peek();
                    parent.left = node;
                    if (nextStr.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ",":
                    parent = treeNodeStack.peek();
                    parent.right = node;
                    if (nextStr.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ")":
                    treeNodeStack.pop();
                    break;
                default:
                    if (nextStr.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
            }
            startIndex = index;
            preStr = String.valueOf(str.charAt(startIndex));
            startIndex++;
            index++;
        }
        return treeNodeStack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = createTree(str);
            zigzagLevelOrder(root);
            /*
            List<String> preResult = new ArrayList<>();
            preResult = pre(root, preResult);
            for (String s : preResult) {
                System.out.print(s + " ");
            }
            System.out.println();
            List<String> levelResult = new ArrayList<>();
            levelResult = level(root, levelResult);
            for (String s : levelResult) {
                System.out.print(s + " ");
            }
            System.out.println();
            */
        }
    }
}
