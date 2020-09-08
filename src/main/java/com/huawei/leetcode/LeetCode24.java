package com.huawei.leetcode;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        return null;
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
        }
    }
}
