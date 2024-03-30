package com.dataStructure.DoubleLinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args){
        System.out.println("* 双向链表测试：");
        HeroNode heroNode1 = new HeroNode(1, "索拉卡", "众星之子");
        HeroNode heroNode2 = new HeroNode(2, "婕拉", "荆棘之兴");
        HeroNode heroNode3 = new HeroNode(3, "佐伊", "暮光星灵");
        HeroNode heroNode4 = new HeroNode(4, "亚索", "疾风剑豪");
        HeroNode heroNode5 = new HeroNode(5, "贾克斯", "武器大师");

        DoubleLinkedList heroesFromLOL = new DoubleLinkedList();

        System.out.println("1.增：向DoubleLinkedList添加5个初始元素");
        heroesFromLOL.add(heroNode1);
        heroesFromLOL.add(heroNode2);
        heroesFromLOL.add(heroNode3);
        heroesFromLOL.add(heroNode4);
        heroesFromLOL.add(heroNode5);
        heroesFromLOL.list();

        System.out.println("2.删：删除序号为3的元素");
        heroesFromLOL.delete(3);
        heroesFromLOL.list();

        System.out.println("3.改：修改序号为5的元素为深渊巨口-克格莫");
        HeroNode updateNode = new HeroNode(5, "克格莫", "深渊巨口");
        heroesFromLOL.update(updateNode);
        heroesFromLOL.list();

        System.out.println("4.增：使用通过序号添加元素的方式添加被删除的3");
        heroesFromLOL.addByIndex(heroNode3);
        heroesFromLOL.list();
    }
}
