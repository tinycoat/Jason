package com.dataStructure.HashTable;

public class EmpLinkedList {
    private Emp head;

    // 添加雇员
    public void add(Emp emp) {
        // 添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 添加非第一个雇员
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    // 遍历链表
    public void list(int no) {
        // 链表为空
        if (head == null) {
            System.out.println("链表" + no + "：当前链表为空");
            return;
        }
        System.out.println("链表" + no + "信息：");
        Emp curEmp = head;
        while (curEmp != null) {
            System.out.println("\t雇员：" + curEmp.name + ", 工号：" + curEmp.id);
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
