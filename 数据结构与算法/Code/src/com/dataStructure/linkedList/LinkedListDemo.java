package com.dataStructure.linkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "莫甘娜", "堕落天使");
        HeroNode hero2 = new HeroNode(2, "露露", "仙灵女巫");
        HeroNode hero3 = new HeroNode(3, "索拉卡", "众星之子");
        HeroNode hero4 = new HeroNode(4, "婕拉", "荆棘之兴");
        HeroNode hero5 = new HeroNode(5, "维克兹", "虚空之眼");

        SingleLinkedList heroesFromLOL = new SingleLinkedList();

        // 增加
//        heroesFromLOL.add(hero2);
//        heroesFromLOL.add(hero5);
//        heroesFromLOL.add(hero3);
//        heroesFromLOL.add(hero1);
//        heroesFromLOL.add(hero4);

        heroesFromLOL.addByOrder(hero2);
        heroesFromLOL.addByOrder(hero5);
        heroesFromLOL.addByOrder(hero3);
        heroesFromLOL.addByOrder(hero1);
        heroesFromLOL.addByOrder(hero4);

        heroesFromLOL.list();

        // 修改
        heroesFromLOL.update(new HeroNode(1, "赛纳", "涤魂圣枪"));

        heroesFromLOL.list();

        // 删除
        heroesFromLOL.delete(3);

        heroesFromLOL.list();

    }
}
