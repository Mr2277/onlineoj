package com.huawei.leetcode.leetcode91_100;


import java.util.*;

public class LeetCode100 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode createTree(int[] nums) {
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //System.out.print(nums[i] + " ");
            if (nums[i] != 0) {
                if (i == 0) {
                    TreeNode treeNode = new TreeNode(nums[i]);
                    treeNode.left = null;
                    treeNode.right = null;
                    treeNodeMap.put(i, treeNode);
                } else if (nums[i] != 0){
                    int parent = (i & 1) == 1 ? i / 2 : (i - 1) / 2;
                    boolean isLeft = (i & 1) == 1 ? true : false;
                    //System.out.println(parent);
                    TreeNode parentNode = treeNodeMap.get(parent);
                    TreeNode treeNode = new TreeNode(nums[i]);
                    treeNode.left =  null;
                    treeNode.right = null;
                    if (isLeft) {
                        parentNode.left = treeNode;
                        treeNodeMap.put(i, treeNode);
                    } else {
                        parentNode.right = treeNode;
                        treeNodeMap.put(i, treeNode);
                    }
                }
            }
        }
        return treeNodeMap.get(0);
    }

    public static List<Integer> pre(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            nodes.add(null);
            return nodes;
        } else {
            nodes.add(root.val);
            nodes = pre(root.left, nodes);
            nodes = pre(root.right, nodes);
        }
        return nodes;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        pList = pre(p, pList);
        StringBuilder pStr = new StringBuilder();
        for (Integer integer : pList) {
            String s = integer == null ? "#" : String.valueOf(integer);
            pStr.append(s);
        }
        // System.out.println(pStr.toString());
        List<Integer> qList = new ArrayList<>();
        qList = pre(q, qList);
        StringBuilder qStr = new StringBuilder();
        for (Integer integer : qList) {
            String s = integer == null ? "#" : String.valueOf(integer);
            qStr.append(s);
        }
        // System.out.println(qStr.toString());
        return qStr.toString().equals(pStr.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            TreeNode p = createTree(nums);
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            TreeNode q = createTree(nums);
            System.out.println(isSameTree(p, q));
        }
    }
}
