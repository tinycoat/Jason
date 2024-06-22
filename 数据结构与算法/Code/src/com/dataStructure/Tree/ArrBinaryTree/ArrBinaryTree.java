package com.dataStructure.Tree.ArrBinaryTree;

public class ArrBinaryTree {
    private int[] arr; // 存储数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }
    /***
     * 子节点：2n+1（左子节点）， 2n+2(右子节点)
     * 父节点：（n-1）/2
     */
    // 完成顺序存储二叉树的前序查找，index代表数组的下标
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法前序遍历");
        }
        // 输出当前节点
        System.out.println(arr[index]);
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空无法中序遍历");
        }
        if ((2 * index) + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if ((2 * index) + 2 < arr.length) {
            infixOrder((2 * index) + 2);
        }
    }

    public void postOrder() {
        this.postOrder(0);
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空无法中序遍历");
        }
        if ((2 * index) + 1 < arr.length) {
            postOrder((2 * index) + 1);
        }
        if ((2 * index) + 2 < arr.length) {
            postOrder((2 * index) + 2);
        }
        System.out.println(arr[index]);
    }
}
