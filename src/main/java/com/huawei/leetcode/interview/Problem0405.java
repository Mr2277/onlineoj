package com.huawei.leetcode.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem0405 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> preLists = new ArrayList<>();
        List<Integer> midLists = new ArrayList<>();
        //preLists = preOrder(root, preLists);
        midLists = midOrder(root, midLists);
        Collections.sort(preLists);
        int i = 0;
        for (i = 0; i < midLists.size() - 1; i++) {
            if (midLists.get(i) >= midLists.get(i + 1)) {
                break;
            }
        }

        return i == midLists.size() - 1 ? true : false;
    }

    public List<Integer> preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
            return result;
        }
    }

    public List<Integer> midOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            midOrder(root.left, result);
            result.add(root.val);
            midOrder(root.right, result);
            return result;
        }
    }
}
