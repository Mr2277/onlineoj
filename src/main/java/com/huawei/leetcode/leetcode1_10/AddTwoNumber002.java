package com.huawei.leetcode.leetcode1_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Node {
    public Integer num;
    public Node next;
}
public class AddTwoNumber002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expresion = scanner.nextLine();
            // System.out.println(expresion);
            String[] plus = expresion.split("[+]");
            Node[] heads = new Node[plus.length];
            for(int i = 0; i < plus.length; i++) {
                String temp = plus[i].trim();
                String linkExpression = temp.substring(1, temp.length() - 1);
                String[] nums = linkExpression.split("->");
                Node head = new Node();
                heads[i] = head;
                Node last = null;
                for(int j = 0; j < nums.length; j++) {
                    Node node = new Node();
                    node.num = Integer.valueOf(nums[j]);
                    node.next = null;
                    if (j == 0) {
                        heads[i].next = node;
                        last = node;
                    } else {
                        last.next = node;
                        last = node;
                    }
                }
            }
            /*
            for(int k = 0; k < plus.length; k++) {
                Node head = heads[k];
                while(head.next != null) {
                    System.out.println(head.next.num);
                    head = head.next;
                }
            }
            */
            Node leftPlus = heads[0];
            Node rightPlus = heads[1];
            int carried = 0;
            List<Integer> result = new ArrayList<Integer>();
            while (leftPlus.next != null && rightPlus.next != null) {
                Integer left = leftPlus.next.num;
                Integer right = rightPlus.next.num;
                if ((left + right + carried) >= 10) {
                    Integer resultPlus = (left + right + carried) - 10;
                    result.add(resultPlus);
                    carried = 1;
                } else {
                    Integer resultPlus = left + right + carried;
                    result.add(resultPlus);
                    carried = 0;
                }
                leftPlus = leftPlus.next;
                rightPlus = rightPlus.next;
            }
            while (leftPlus.next != null) {
                Integer left = leftPlus.next.num;
                if ((carried + left) >= 10) {
                    Integer resultPlus = carried + left - 10;
                    result.add(resultPlus);
                    carried = 1;
                } else {
                    Integer resultPlus = left + carried;
                    result.add(resultPlus);
                    carried = 0;
                }
                leftPlus = leftPlus.next;
            }
            while (rightPlus.next != null) {
                Integer right = rightPlus.next.num;
                if ((carried + right) >= 10) {
                    Integer resultPlus = carried + right -10;
                    result.add(resultPlus);
                    carried = 1;
                } else {
                    Integer resultPlus = carried + right;
                    result.add(resultPlus);
                    carried = 0;
                }
                rightPlus = rightPlus.next;
            }
            if (carried == 1) {
                result.add(carried);
                carried = 0;
            }
            for (Integer integer : result) {
                System.out.print(integer + "#");
            }

        }
    }
}
