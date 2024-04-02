package com.dataStructure.Stack;

public class ArrayStack {
    private int top;
    public final int maxSize;
    private final int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == - 1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("栈已满，无法添加元素");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        return stack[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("无元素，栈为空！");
            return;
        }
        int temp = top;
        while(temp != -1) {
            System.out.printf("stack[%d] = %d，maxSize = %d\n", temp, stack[temp], maxSize);
            temp--;
        }
    }
}
