package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode21_30;

import java.util.Scanner;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, current = head, next = head;
        while (current != tail) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
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
            // StringBuilder builder = new StringBuilder();
        }
    }
}
