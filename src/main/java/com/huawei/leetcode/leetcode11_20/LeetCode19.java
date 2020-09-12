package com.huawei.leetcode.leetcode11_20;


import java.util.Scanner;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            //移除的是头节点
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n --;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void foreachNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            ListNode head = new ListNode(Integer.MAX_VALUE);
            ListNode temp = head;
            for (int i = 0; i < num; i++) {
                int curNum = scanner.nextInt();
                ListNode node = new ListNode(curNum);
                node.next = null;
                temp.next = node;
                temp = node;
            }
            int n = scanner.nextInt();
            foreachNode(removeNthFromEnd(head, n));
        }
    }
}
