package com.huawei.leetcode.leetcode21_30;

import java.util.Scanner;


public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;

        // next 后面就不管了，直接递归。。。。
        next.next = swapPairs(next.next);

        //下面两行代码是交换链表两个节点
        head.next = next.next;
        next.next = head;

        // 交换后，next 就是前面的节点
        return next;
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
            // swapPairs(head);
        }
    }

}
