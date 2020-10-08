package com.huawei.leetcode.leetcode101_200.leetcode101_110;

import java.util.*;

public class LeetCode102 {
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
    /*
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfsList = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        int front = 0, rear = 0;
        if (root != null) {
            nodes.add(root);
            front++;
        }
        while (rear < front) {
            if (nodes.get(rear) != null) {
                TreeNode leftNode = nodes.get(rear).left;
                nodes.add(leftNode);
                front++;
                TreeNode rightNOde = nodes.get(rear).right;
                nodes.add(rightNOde);
                front++;
            }
            rear++;
        }
        int count = 0;
        int level = (int) (Math.pow(2, count) - 1);
        for (int i = 0; i < nodes.size(); i++) {
            if (i == level) {
                List<Integer> subResult = new ArrayList<>();
                if (nodes.get(i) != null) {
                    subResult.add(nodes.get(i).val);
                }
                bfsList.add(subResult);
                count++;
                level = (int) (Math.pow(2, count) - 1);

            } else {
                List<Integer> subResult = bfsList.get(bfsList.size() - 1);
                if (nodes.get(i) != null) {
                    subResult.add(nodes.get(i).val);
                }
            }
        }
        //System.out.println(bfsList.size());
        bfsList = bfsList.stream().filter(s -> s.size() > 0).collect(Collectors.toList());
        //System.out.println(bfsList.size());
        return bfsList;
    }
    */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();//root不为空时，此时第一层的节点数是n=1；
            List<Integer> list = new ArrayList<>();
            /*再进行n次循环，确保当前层的节点全部出队列，
              并把所有当前层节点的左右孩子加入队列，
              保证队列的size就是下一层的节点数。
            */
            for(int i = 0;i < n;i++){
                root = queue.poll();
                list.add(root.val);
                if(root.left != null)
                    queue.add(root.left);
                if(root.right != null)
                    queue.add(root.right);
            }
            res.add(list);
        }
        return res;


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
            levelOrder(p);
        }
    }
}
