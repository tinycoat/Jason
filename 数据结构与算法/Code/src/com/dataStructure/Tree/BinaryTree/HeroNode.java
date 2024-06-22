package com.dataStructure.Tree.BinaryTree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this); // 先输出父节点
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序+1");
        if (this.no == no) { // 比较当前节点
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) { // 前序遍历查找左子树
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) { // 左子树找到
            return resNode;
        }
        if (this.right != null) { // 前序遍历查找右子树
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) { // 中序遍历左子树
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) { // 左子树找到
            return resNode;
        }
        System.out.println("中序+1");
        if (this.no == no) { // 比较当前节点
            return this;
        }
        if (this.right != null) { // 中序遍历右子树
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后序遍历
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) { // 后序遍历左子树
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) { // 左子树找到
            return resNode;
        }
        if (this.right != null) { //后序遍历右子树
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) { // 右子树找到
            return resNode;
        }
        System.out.println("后序+1");
        if (this.no == no) { // 比较当前节点
            return this;
        }
        return resNode;
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) { // 判断当前节点的左节点是否为待删除节点
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) { // 判断当前节点的右节点是否为待删除节点
            this.right = null;
            return;
        }
        if (this.left != null) { // 左子树递归删除
            this.left.delNode(no);
        }
        if (this.right != null) { // 右子树递归删除
            this.right.delNode(no);
        }
    }
}
