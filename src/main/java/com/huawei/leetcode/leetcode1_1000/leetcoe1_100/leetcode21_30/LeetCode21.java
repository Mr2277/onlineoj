package com.huawei.leetcode.leetcode1_1000.leetcoe1_100.leetcode21_30;



import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LeetCode21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode mergeHead = new ListNode(Integer.MIN_VALUE);
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode mergeTemp = mergeHead;
        while (l1Head != null && l2Head != null) {
            if (l1Head.val <= l2Head.val ) {
                ListNode node = new ListNode(l1Head.val);
                node.next = null;
                mergeTemp.next = node;
                mergeTemp = node;
                l1Head = l1Head.next;
            } else {
                ListNode node = new ListNode(l2Head.val);
                node.next = null;
                mergeTemp.next = node;
                mergeTemp = node;
                l2Head = l2Head.next;
            }
        }
        while (l1Head != null) {
            ListNode node = new ListNode(l1Head.val);
            node.next = null;
            mergeTemp.next = node;
            mergeTemp = node;
            l1Head = l1Head.next;
        }
        while (l2Head != null) {
            ListNode node = new ListNode(l2Head.val);
            node.next = null;
            mergeTemp.next = node;
            mergeTemp = node;
            l2Head = l2Head.next;
        }
        return mergeHead.next;
    }

    public static void foreachNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ListNode leftHead = new ListNode(Integer.MAX_VALUE);
            ListNode leftTemp = leftHead;
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                ListNode node = new ListNode(val);
                node.next = null;
                leftTemp.next = node;
                leftTemp = node;
            }
            int m = scanner.nextInt();
            ListNode rightHead = new ListNode(Integer.MAX_VALUE);
            ListNode rightTemp = rightHead;
            for (int j = 0; j < m; j++) {
                int val = scanner.nextInt();
                ListNode node = new ListNode(val);
                node.next = null;
                rightTemp.next = node;
                rightTemp = node;
            }
            foreachNode(mergeTwoLists(leftHead.next, rightHead.next));
        }
    }
}
