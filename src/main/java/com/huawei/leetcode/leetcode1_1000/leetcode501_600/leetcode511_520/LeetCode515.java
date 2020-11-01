package com.huawei.leetcode.leetcode1_1000.leetcode501_600.leetcode511_520;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode515 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

    public static List<Integer> largestValues(TreeNode root) {
        Map<Integer, List<Integer>> levelNodeMap = new HashMap<>();
        levelNodes(root, levelNodeMap, 1);
        levelNodeMap = levelNodes(root, levelNodeMap, 1);
        List<Integer> result = new ArrayList<>();
        Iterator iterator = levelNodeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            List<Integer> list = (List<Integer>) entry.getValue();
            list = list.stream().distinct().collect(Collectors.toList());
            int max = Integer.MIN_VALUE;
            for (Integer integer : list) {
                if (integer > max) {
                    max = integer;
                }
            }
            result.add(max);
        }
        return result;
    }

    public static Map<Integer, List<Integer>> levelNodes(TreeNode root, Map<Integer, List<Integer>> levelNodeMap, int depth) {
        if (root == null) {
            return levelNodeMap;
        }
        if (!levelNodeMap.containsKey(depth)) {
            List<Integer> levelNodeList = new ArrayList<>();
            levelNodeList.add(root.val);
            levelNodeMap.put(depth, levelNodeList);
        } else {
            List<Integer> levelNodeList = levelNodeMap.get(depth);
            levelNodeList.add(root.val);
        }
        levelNodes(root.left, levelNodeMap, depth + 1);
        levelNodes(root.right, levelNodeMap, depth + 1);
        return levelNodeMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            TreeNode root = create(str);
            largestValues(root);
        }
    }
}
