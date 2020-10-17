package com.huawei.leetcode.leetcode1001_2000.leetcode1301_1400.leetcode1371_1380;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LeetCode1372 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode create(String str) {
        int index = 0;
        char ch = str.charAt(index);
        String cur = "", pre = "", next = "";
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode parent = null, node = null;
        while (index < str.length()) {
            while (ch >= '0' && ch <= '9' || ch == '#') {
                cur += ch;
                index++;
                ch = str.charAt(index);
            }
            next = String.valueOf(ch);
            if (!"".equals(cur) && !cur.equals("#")) {
                Integer curVal = Integer.valueOf(cur);
                node = new TreeNode(curVal);
                node.left = null;
                node.right = null;
            }
            switch (pre) {

                case "(":
                    parent = treeNodeStack.peek();
                    if (!cur.equals("#")) {
                        parent.left = node;
                    }
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ",":
                    parent = treeNodeStack.peek();
                    if (!cur.equals("#")) {
                        parent.right = node;
                    }
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
                case ")":
                    treeNodeStack.pop();
                    break;
                default:
                    if (next.equals("(")) {
                        treeNodeStack.add(node);
                    }
                    break;
            }

            pre = "".equals(cur) ? String.valueOf(str.charAt(index)) : next;
            cur = "";
            index++;
            ch = index < str.length() ? str.charAt(index) : ')';
        }
        return treeNodeStack.peek();
    }
    /*
    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            List<Integer> subResult = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            DFS(root, true, result, subResult);
            DFS(root, false, result, subResult);
            int maxleft = longestZigZag(root.left);
            int maxright = longestZigZag(root.right);
            int max = -1;
            for (List<Integer> list : result) {
                max = list.size() > max ? list.size() : max;

                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();

            }
            maxleft = Integer.max(maxleft, maxright);
            return Integer.max(max - 1, maxleft);
        }
    }
    */
    /*
    public static List<List<Integer>> DFS(TreeNode root, boolean isLeft, List<List<Integer>> result, List<Integer> subResult) {
        if (root == null) {
            if (!subResult.isEmpty()) {
                List<Integer> subResultCopy = new ArrayList<>(subResult);
                result.add(subResultCopy);
            }
            return result;
        } else if (root.left == null && root.right == null){
            //subResult.add(root.val);
            List<Integer> subResultCopy = new ArrayList<>(subResult);
            subResultCopy.add(root.val);
            result.add(subResultCopy);
            return result;
        } else {
            subResult.add(root.val);
            if (isLeft) {
                DFS(root.right, false, result, subResult);
            } else {
                DFS(root.left, true, result, subResult);
            }
            subResult.remove(subResult.size() - 1);
            return result;
        }
    }
    static int max = 0;
    public static int longestZigZag(TreeNode root) {
        int max = 0;
        System.out.println(helper(root.left,true));
        System.out.print(helper(root.right,false));
        max = Math.max(helper(root.left,true)+1,max);
        max = Math.max(helper(root.right,false)+1,max);
        return max;
    }

    public static int helper(TreeNode root, boolean left){
        if(root == null){
            return -1;
        }
        int leftV = helper(root.left,true);
        int rightV = helper(root.right,false);
        max = Math.max(Math.max(leftV+1,max),rightV+1);
        if(left){
            return rightV+1;
        }else{
            return leftV+1;
        }

    }
    */
    private static int result = 0;
    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return -1;
        }
        DFS(root, true);
        DFS(root, false);
        return result;
    }

    public static int DFS(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else {
            int left = DFS(root.left, true);
            int right = DFS(root.right ,false);
            int max = Integer.max(left, right);
            result = Integer.max(max, result);
            return isLeft ? right + 1 : left + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
          longestZigZag(root);
        }
    }
}
