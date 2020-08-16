package com.huawei.test;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carried = 0;
        while (l1 != null && l2 !=  null) {
            int left = l1.val;
            int right = l2.val;
            if (left + right + carried >= 10) {
                int result = left + right + carried - 10;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 1;
            } else {
                int result = left + right +carried;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int left = l1.val;
            if(left + carried >= 10) {
                int result = left + carried - 10;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 1;
            } else {
                int result = left + carried;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 0;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int right = l2.val;
            if(right + carried >= 10) {
                int result = right + carried - 10;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 1;
            } else {
                int result = right + carried;
                ListNode node = new ListNode(result);
                node.next = null;
                temp.next = node;
                temp = node;
                carried = 0;
            }
            l2 = l2.next;
        }
        if (carried == 1) {
            ListNode node = new ListNode(1);
            node.next = null;
            temp.next = node;
        }
        return head.next;
    }
}


public class TestAddTwoNumber002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-2);
        ListNode left = l1;
        ListNode headLeft = left;
        ListNode right = l2;
        ListNode headRight = l2;
        while (scanner.hasNext()) {
            int leftNum = scanner.nextInt();
            System.out.println(leftNum);
            for (int i = 0; i < leftNum; i++) {
                int leftVal = scanner.nextInt();
                System.out.println(leftVal + "$");
                ListNode node = new ListNode(leftVal);
                node.next = null;
                left.next = node;
                left = node;
            }
            int rightNum = scanner.nextInt();
            System.out.println(rightNum);
            for (int j = 0; j < rightNum; j++) {
                int rightVal = scanner.nextInt();
                ListNode node = new ListNode(rightVal);
                node.next = null;
                right.next = node;
                right = node;
            }
            Solution solution = new Solution();
            solution.addTwoNumbers(headLeft.next, headRight.next);
        }
    }
}
