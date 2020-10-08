package com.huawei.leetcode.leetcode101_200.leetcode101_110;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode101 {

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

    public static boolean isSymmetric(TreeNode root) {
        StringBuilder builderLeft = new StringBuilder();
        String strLeft = preLeft(root, builderLeft).toString();
        StringBuilder builderRight = new StringBuilder();
        String strRight = preRight(root, builderRight).toString();
        System.out.println(strLeft);
        System.out.println(strRight);
        return strLeft.equals(strRight);
    }

    public static StringBuilder preLeft(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#");
            return stringBuilder;
        } else {
            stringBuilder.append(root.val);
            stringBuilder = preLeft(root.left, stringBuilder);
            stringBuilder = preLeft(root.right, stringBuilder);
        }
        return stringBuilder;
    }

    public static StringBuilder preRight(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#");
            return stringBuilder;
        } else {
            stringBuilder.append(root.val);
            stringBuilder = preRight(root.right, stringBuilder);
            stringBuilder = preRight(root.left, stringBuilder);
        }
        return stringBuilder;
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
            System.out.println(isSymmetric(p));
        }
    }
}
