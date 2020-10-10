package com.huawei.leetcode.leetcoe1_100.leetcode91_100;

import java.util.*;

public class LeetCode95 {

   static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
  }

  public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        if (n == 0) {
            return nodes;
        }
        boolean[] flag = new boolean[n];
        List<Integer> subResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result = permutation(n, flag, subResult, result);
        Set<String> preStrSet = new HashSet<>();
        for (List<Integer> list : result) {
            TreeNode node = (createTree(list));
            StringBuilder stringBuilder = new StringBuilder();
            String preOrderStr = preString(node, stringBuilder);
            if (preStrSet.isEmpty() || !preStrSet.contains(preOrderStr)) {
                nodes.add(node);
                preStrSet.add(preOrderStr);
            }
        }
        return nodes;
    }

    public  static TreeNode createTree(List<Integer> nodes) {
        TreeNode root = null;
        for (Integer integer : nodes) {
            if (root == null) {
                root = new TreeNode(integer);
                root.left = null;
                root.right = null;
            } else {
                TreeNode node = root;
                while (true) {
                    if (integer > node.val) {
                        if (node.right == null) {
                            TreeNode rightNode = new TreeNode(integer);
                            rightNode.right = null;
                            rightNode.left = null;
                            node.right = rightNode;
                            break;
                        } else {
                            node = node.right;
                        }
                    } else {
                        if (node.left == null) {
                            TreeNode leftNode = new TreeNode(integer);
                            leftNode.left = null;
                            leftNode.right = null;
                            node.left = leftNode;
                            break;
                        } else {
                            node = node.left;
                        }
                    }
                }
            }
        }
        return root;
    }

    public static List<List<Integer>> permutation(int n, boolean flag[], List<Integer> subResult, List<List<Integer>> result) {
        if (subResult.size() == n) {
            List<Integer> copySubResult = new ArrayList<>(subResult);
            result.add(copySubResult);
            return result;
        } else {
            for (int i = 0; i < n; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    subResult.add(i + 1);
                    permutation(n, flag, subResult, result);
                    subResult.remove(subResult.size() - 1);
                    flag[i] = false;
                }
            }
            return result;
        }
    }


    public static String preString(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return stringBuilder.toString();
        } else {
            stringBuilder.append(root.val);
            preString(root.left, stringBuilder);
            preString(root.right, stringBuilder);
            return stringBuilder.toString();
        }
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while (scanner.hasNext()) {
           int n = scanner.nextInt();
           generateTrees(n);
           /*
           List<Integer> list = new ArrayList<>();
           list.add(2);
           list.add(3);
           list.add(1);
           list.add(4);
           createTree(list);
           */
       }
    }

}
