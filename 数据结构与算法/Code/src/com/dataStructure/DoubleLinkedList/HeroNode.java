package com.dataStructure.DoubleLinkedList;

public class HeroNode {
    public int heroNum; // 英雄的唯一表标识
    public String heroName;
    public String nickName;
    public HeroNode next;   // 默认为null
    public HeroNode pre;    // 默认为null

    public HeroNode(int heroNum, String heroName, String nickName) {
        this.heroNum = heroNum;
        this.heroName = heroName;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "heroNum=" + heroNum +
                ", heroName='" + heroName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
