package com.huawei.leetcode.leetcode1_1000.leetcode201_300.leetcode221_230;

import java.util.ArrayList;
import java.util.List;

public class LeetCode222 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    /*
    public static int countNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = preOrder(root, result);
        return result.size();
    }

    public static List<Integer> preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
            return result;
        }
    }
    */

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public static void main(String[] args) {

    }
}
