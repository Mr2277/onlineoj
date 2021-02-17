package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            node.left = null;
            node.right = null;
            return node;
        }
        int sum = (end + start);
        int mid = (sum & 1) == 1 ? (sum + 1) / 2 : sum / 2;
        TreeNode left = dfs(nums, start, mid - 1);
        TreeNode right = dfs(nums, mid + 1, end);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-10, -3, 0, 5, 9};
        new LeetCode108().sortedArrayToBST(nums);
    }
}
