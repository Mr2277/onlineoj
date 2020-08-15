package com.huawei.test;

import java.util.Scanner;

class Node{
    public Integer integer;
    public Node next;
}
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = new Node();
        head.next = null;
        Node temp = head;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0;i < n;i++) {
                Node node = new Node();
                node.integer = i;
                temp.next = node;
                temp = node;
            }
            Node iter = head.next;
            while (iter != null) {
                System.out.println(iter.integer);
                iter = iter.next;
            }
        }
    }
}
