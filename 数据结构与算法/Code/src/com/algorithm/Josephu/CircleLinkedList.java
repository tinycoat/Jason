package com.algorithm.Josephu;

public class CircleLinkedList {
    private Boy first;
    public int totalRecords;

    // 创建循环链表
    public CircleLinkedList(int num) {
        if (num < 1) {
            throw new RuntimeException("人数设置不合理！");
        }
        totalRecords = num;
        first = new Boy(1);
        Boy curBoy = first;
        for (int i = 2; i <= num; i++) {
            curBoy.setNext(new Boy(i));
            curBoy = curBoy.getNext();
            curBoy.setNext(first);
        }
    }

    // 打印循环链表
    public void list() {
        if (first == null) {
            System.out.println("没有小孩儿...");
            return;
        }
        Boy curBoy = first;
        while (curBoy.getNext() != first) {
            System.out.println(curBoy);
            curBoy = curBoy.getNext();
        }
        System.out.println(curBoy);
    }

    /**
     * 约瑟夫小孩出圈方法
     * @param starNum 从几号小孩开始数
     * @param count 每数到count的小孩儿出圈
     * @param num 总共多少个小孩儿
     */
    public void countBoy(int starNum, int count) {
        if (first == null) {
            throw new RuntimeException("链表为空！");
        }
        if (starNum < 1 || starNum > totalRecords) {
            throw new RuntimeException("起始序号不合理！");
        }
        if (count < 1 || count > totalRecords) {
            throw new RuntimeException("间隔数不合理！");
        }
        // 让helper指向first的前一个
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // 定位到开始的小孩
        for (int i = 0; i < starNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始出圈
        while (helper != first) {
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("序号为 " + first.index + " 的小孩儿出列~");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈内的小孩是" + first);
    }
}
