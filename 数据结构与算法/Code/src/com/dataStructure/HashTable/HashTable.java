package com.dataStructure.HashTable;

public class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        // 初始化
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            this.empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 根据员工的id，得到该员工应当添加到那条链表
        int empNo = hashFun(emp.id);
        empLinkedListArray[empNo].add(emp);
    }

    // 散列函数--取模法
    public int hashFun(int id) {
        return id % size;
    }

    // 遍历所有链表
    public void list() {
        for (int i= 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id查找
    public void findEmpById (int id) {
        int empNo = hashFun(id);
        Emp emp = empLinkedListArray[empNo].findEmpById(id);
        if (emp != null) {
            System.out.println("员工：" + emp.name + " " + emp.id);
        } else {
            System.out.println("哈希表中无此雇员");
        }
    }


}
