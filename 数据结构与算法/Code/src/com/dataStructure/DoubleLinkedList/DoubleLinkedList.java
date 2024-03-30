package com.dataStructure.DoubleLinkedList;

public class DoubleLinkedList {
    private static final HeroNode head = new HeroNode(0, "", "");

    public static HeroNode getHead() {
        return head;
    }


    // 查：打印双向链表，同单向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


    // 增：向双向链表添加元素(尾部添加)
    public void add(HeroNode newNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }


    // 增：按照编号大小添加元素（按顺序）
    public void addByIndex(HeroNode newNode) {
        if (newNode.heroNum < 1) {
            throw new RuntimeException("不合理的元素！heroNum > 0!");
        }
        HeroNode temp = head;

        while (temp.next != null) {
            if (temp.next.heroNum == newNode.heroNum) {
                System.out.println("当前链表中已经含有HeroNum为" + newNode.heroNum + "的节点，无法加入！");
                return;
            }
            if (temp.next.heroNum > newNode.heroNum) {
                newNode.next = temp.next;
                temp.next.pre = newNode;
                temp.next = newNode;
                newNode.pre = temp;
                return;
            }
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;

        // 另一种写法
        /*
        while (temp.next != null && temp.next.heroNum < newNode.heroNum) {
            temp = temp.next;
        }
        // 位置不能发生变化，发生变化会空指针
        if (temp.next == null) {
            temp.next = newNode;
            newNode.pre = temp;
            return;
        }
        if (temp.next.heroNum == newNode.heroNum) {
            System.out.println("当前链表中含有HeroNum为" + newNode.heroNum + "的节点，无法添加！");
            return;
        }
        HeroNode nextNode = temp.next;
        temp.next = newNode;
        newNode.pre = temp;
        newNode.next = nextNode;
        nextNode.pre = newNode;
        */
    }


    // 改：更新双向链表中的元素
    public void update(HeroNode updateNode) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        boolean isExist = false;
        while (temp != null) {
            if (temp.heroNum == updateNode.heroNum) {
                temp.heroName = updateNode.heroName;
                temp.nickName = updateNode.nickName;
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (!isExist) {
            System.out.println("未找到HeroNum为" + updateNode.heroNum + "的节点，无法修改");
        }
    }


    // 删：删除双向链表中的元素
    public void delete(int index) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除！");
        }
        HeroNode temp = head.next;
        boolean isExist = false;
        while (temp != null) {
            if (temp.heroNum == index) {
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isExist) {
            // 注意！假如删除最后一个节点会出现空指针的问题！！！
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("链表中不存在HeroNum为" + index + "的英雄，无法删除！");
        }
    }
}
