package com.huawei.leetcode.leetcode1_1000.leetcode601_700.leetcode631_640;

import com.huawei.kexin.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode635 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) + list.get(end) == k) {
                return true;
            } else if (list.get(start) + list.get(end) > k) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    public List<Integer> dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
        return list;
    }

    public static void main(String[] args) {
        String str = "2(1,3)";
        TreeNode root = TreeNode.create(str);
        LeetCode635 leetCode635 = new LeetCode635();
        System.out.println(leetCode635.findTarget(root, 4));
    }
}
