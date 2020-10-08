package com.huawei.leetcode.leetcode101_200.leetcode101_110;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode110 {
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
    // 标记，默认树是平衡的（比如空树）
    boolean flag = true;
    /*
    public boolean isBalanced(TreeNode root) {
        // dfs 后序遍历判断是否不平衡
        dfs(root);

        return flag;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左右子树最深深度
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;

        // AVL树 —— 平衡因子：当 左子树深度 - 右子树深度的绝对值 > 1 时
        // 需要进行LL、RR、LR、RL旋转让其恢复平衡，这也是为什么我们最后
        // 选择返回左右子树中最深的深度。因为平衡因子受到其制约。
        // AVL树中的平衡因子可为 -1，0，1，又因为我们需要得到左右子树深度
        // 后才能计算平衡因子，理所当然地选择后序遍历（左右根）去 get 答案~
        // 还是不太理解的话，建议去学习一下数据结构 —— BST、AVL这两部分
        if (Math.abs(left - right) > 1) {
            flag = false;
        }

        return Math.max(left, right);
    }
    */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        String str = treeDeep(root, 1);
        System.out.println(str);
        //return Math.abs(leftDeepth - rirhtDeepth) <= 1 ? true : false;
        return false;
    }

    public static String treeDeep(TreeNode root, int deep) {
        if (root == null) {
            return String.valueOf(deep);
        } else {
           String leftdeep = treeDeep(root.left, deep + 1);
           String rightdeep = treeDeep(root.right, deep + 1);
           return leftdeep + "_" + rightdeep;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            isBalanced(createTree(nums));
        }
    }
}
