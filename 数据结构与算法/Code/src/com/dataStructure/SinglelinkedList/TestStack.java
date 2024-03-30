package com.dataStructure.SinglelinkedList;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("jack");
        stack.add("smith");
        stack.add("jason");

        // 入栈
        System.out.println(stack.toString());

        // 出栈，后入先出
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
