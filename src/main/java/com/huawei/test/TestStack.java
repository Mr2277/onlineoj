package com.huawei.test;

import java.util.Iterator;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("a");
        stack.add("b");
        stack.add("c");
        System.out.println(stack.peek());
        stack.empty();
        System.out.println(stack.size());

        //Stack<String> stack = new Stack();
        stack.add("a");
        stack.add("b");
        stack.add("c");
        System.out.println(stack.peek());
        stack.empty();
        System.out.println(stack.size());
    }
}
