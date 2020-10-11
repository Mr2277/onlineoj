package com.huawei.leetcode.jianqiaooffer;

public class Offer26 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    /*
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean judge(TreeNode A, TreeNode B) {
        return (A == null || B == null) ?
                (B == null) :
                (A.val == B.val) && judge(A.left, B.left) && judge(A.right, B.right);
    }
    */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        } else {
            return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public static boolean judge(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return B == null;
        } else {
            if (A.val != B.val) {
                return false;
            }
            return judge(A.left, B.left) && judge(A.right, B.right);
        }
    }
}
