package com.huawei.leetcode.leetcode101_200.leetcode101_110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode109 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
        return sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null : DFS(nums,0, nums.length - 1);
    }

    public static TreeNode DFS(int[] nums, int start, int end) {
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            node.left = null;
            node.right = null;
            return node;
        } else if (start > end) {
            return null;
        } else {
            int length = end - start;
            int mid = (length & 1) == 1 ? (end + start + 1) / 2 : (start + end) /2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = DFS(nums, start, mid - 1);
            node.right = DFS(nums, mid + 1, end);
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ListNode head = null, temp = null;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                ListNode node = new ListNode(num);
                node.next = null;
                if (temp != null) {
                    temp.next = node;
                }
                temp = node;
                if (i == 0) {
                    head = temp;
                }
            }
        }
    }
}
