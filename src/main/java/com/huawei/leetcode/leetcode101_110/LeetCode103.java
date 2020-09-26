package com.huawei.leetcode.leetcode101_110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

        }
    }
}
