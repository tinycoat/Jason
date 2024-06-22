package com.dataStructure.Tree.BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        // 创建需要的节点
        HeroNode root = new HeroNode(1, "婕拉");
        HeroNode node2 = new HeroNode(2, "露露");
        HeroNode node3 = new HeroNode(3, "拉克丝");
        HeroNode node4 = new HeroNode(4, "亚托克斯");
        HeroNode node5 = new HeroNode(5, "盖伦");
        HeroNode node6 = new HeroNode(6, "德莱厄斯");

        /* 手动创建树
        *       1
        *   2       3
        *       5       4
        */

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        node2.setLeft(node6);

        // 测试前序遍历
        System.out.println("前序遍历:");
        binaryTree.preOrder();

        // 测试中序遍历
        System.out.println("中序遍历:");
        binaryTree.infixOrder();

        // 测试后序遍历
        System.out.println("后序遍历:");
        binaryTree.postOrder();

        // 测试前序查找
        System.out.println("前序遍历查找方式");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.println("已查找到：" + resNode);
        } else {
            System.out.println("未找到相关结果！");
        }

        // 测试中序查找
        System.out.println("中序遍历查找方式");
        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
        if (resNode1 != null) {
            System.out.println("已查找到：" + resNode1);
        } else {
            System.out.println("未找到相关结果！");
        }

        // 测试后续查找
        System.out.println("后序遍历查找方式");
        HeroNode resNode2 = binaryTree.postOrderSearch(5);
        if (resNode2 != null) {
            System.out.println("已查找到：" + resNode2);
        } else {
            System.out.println("未找到相关结果！");
        }

        // 测试删除节点
        System.out.println("前序遍历删除前：");
        binaryTree.preOrder();
        binaryTree.delNode(6);
        System.out.println("前序遍历删除后：");
        binaryTree.preOrder();

    }
}
