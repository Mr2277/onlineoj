package com.huawei.leetcode.leetcode21_30;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for(int i=0;i<lists.length;i++) {
            while(lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while( !queue.isEmpty() ) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

        }
    }
}
*/