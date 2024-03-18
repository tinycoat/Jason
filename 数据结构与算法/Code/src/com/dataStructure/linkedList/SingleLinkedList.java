package com.dataStructure.linkedList;

public class SingleLinkedList {
    // 头节点
    private HeroNode head = new HeroNode(0, "", "");

    // 向链表尾部添加数据
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        // 遍历链表，如果temp.next == null，到最后了
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 退出循环时指向最后一个节点
        temp.next = heroNode;
    }

    // 按照编号添加数据
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;   // 标志添加的编号是否存在，默认false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.heroNum > heroNode.heroNum) {
                break;
            }
            if (temp.next.heroNum == heroNode.heroNum) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("该英雄已存在，编号%d，无法添加", temp.heroNum);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;   // 表示是否找到
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.heroNum == newHeroNode.heroNum) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.heroName = newHeroNode.heroName;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("未找到编号为%d的节点，无法修改", newHeroNode.heroNum);
        }
    }

    // 删除节点
    public void delete(int heroNum) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.heroNum == heroNum) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("链表中无该元素，无法删除");
        }
    }

    // 显示链表
    public void list() {
        // 判空
        if (head.next == null) {
            System.out.println("链表为空，无数据");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}
