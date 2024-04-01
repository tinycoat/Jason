package com.algorithm.Josephu;

/**
 * 问题：设编号为1，2，...，n的n个人围坐成一圈，约定编号为k（1<=k<=n）的人开始从1报数，数到m的人出列，
 * 他的下一个人从1开始报数，数到m的人出列。以此类推，直到所有人出列位置，产生一个出队编号的序列
 *
 * 分析：使用单向环形链表实现
 */
public class Josephu {

    public static void main(String[] args) {
        // 单向循环链表创建
        CircleLinkedList circleLinkedList = new CircleLinkedList(3);
        // 单向循环链表遍历
        circleLinkedList.list();
        // 约瑟夫问题求解
        circleLinkedList.countBoy(3, 2);
    }
}