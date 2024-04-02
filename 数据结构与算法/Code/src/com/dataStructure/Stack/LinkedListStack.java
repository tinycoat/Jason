package com.dataStructure.Stack;

import java.util.LinkedList;

public class LinkedListStack {
    public int maxSize;
    public final ListElement head;
    public ListElement temp;
    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        head = new ListElement(-1);
        temp = head;
        ListElement helper = head;
        for (int i = 0; i < maxSize; i++) {
            helper.next = new ListElement(i);
            helper = helper.next;
        }
    }

    public boolean isEmpty() {
        return temp == head;
    }

    public boolean isFull() {
        return temp.next == null;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("\n栈为空，无数据\n");
            return;
        }
        ListElement helper = head;
        for (int i = temp.index; i >= 0; i--) {
            while (helper.next.index < i) {
                helper = helper.next;
            }
            System.out.println(helper.next);
            helper = head;
        }
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("\n栈满，无法加入！\n");
            return;
        }
        temp = temp.next;
        temp.setValue(num);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("\n栈为空！无法取出数据！");
        }
        int num = temp.getValue();
        ListElement newTemp = head;
        while (newTemp.next != temp) {
            newTemp = newTemp.next;
        }
        temp = newTemp;
        return num;
    }
}
