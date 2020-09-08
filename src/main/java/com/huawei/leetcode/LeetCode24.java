package com.huawei.leetcode;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode24 {

    public static ListNode swapPairs(ListNode head) {
        return null;
    }

    public static ListNode DFS(ListNode left, ListNode right, int length) {
        if (length <= 2) {
            if (length == 2) {
                right.next = left;
                left.next = null;
                return left;
            }
            else {
                return left;
            }
        } else {
            int n = (length + 1) / 2;
            int count = 0;
            while (count < n - 1) {
                count ++;
                right = right.next;
            }
            ListNode tempLeft = DFS(left, right, n);
            while (right.next != null) {
                left = left.next;
                right = right.next;
            }
            ListNode tempRight =  v
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ListNode head = new ListNode(Integer.MAX_VALUE);
            ListNode temp = head;
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                ListNode node = new ListNode(val);
                node.next = null;
                temp.next = node;
                temp = node;
            }
            swapPairs(head);
        }
    }
}
