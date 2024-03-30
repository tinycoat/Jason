package com.dataStructure.SinglelinkedList;

public class HeroNode {
    public int heroNum;
    public String heroName;
    public String nickName;
    public HeroNode next;

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
