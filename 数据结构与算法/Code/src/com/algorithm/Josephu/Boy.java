package com.algorithm.Josephu;

public class Boy {
    public int index;
    private Boy next;
    public Boy(int index) {
        this.index = index;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy index=" + index;
    }
}
