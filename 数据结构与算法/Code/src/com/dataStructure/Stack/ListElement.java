package com.dataStructure.Stack;

public class ListElement {
    public int index;
    private int value;
    public ListElement next;

    public ListElement(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "stack[" + index + "] = " + value;
    }
}