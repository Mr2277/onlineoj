package com.huawei.leetcode.jianqiaooffer;

import java.util.ArrayList;
import java.util.List;

public class Offer54 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        result = midOrder(root, result);
        return result.get(result.size() - k);
    }

    public static List<Integer> midOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return result;
        } else {
            midOrder(node.left, result);
            result.add(node.val);
            midOrder(node.right, result);
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
