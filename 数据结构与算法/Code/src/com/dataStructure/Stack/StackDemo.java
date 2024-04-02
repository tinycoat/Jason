package com.dataStructure.Stack;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
//        testArrayStack();
        testLinkedListStack();
    }

    public static void testArrayStack() {
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = new ArrayStack(3);
        System.out.printf("arrayStack测试-栈，栈的最大容量为%d\n", arrayStack.maxSize);
        boolean signal = true;
        while (signal) {
            System.out.print("请输入a->入栈，p->出栈，q->退出程序：");
            char index = scanner.next().charAt(0);
            switch (index){
                case 'a':
                    System.out.print("添加一个数：");
                    int pushNum = scanner.nextInt();
                    arrayStack.add(pushNum);
                    arrayStack.list();
                    break;
                case 'p':
                    System.out.println("从栈中取出一个数：");
                    int popNum;
                    try {
                        popNum = arrayStack.pop();
                        System.out.println("取出的是：" + popNum);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    arrayStack.list();
                    break;
                case 'q':
                    System.out.println("退出程序");
                    signal = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    public static void testLinkedListStack() {
        Scanner scanner = new Scanner(System.in);
        LinkedListStack linkedListStack = new LinkedListStack(3);
        System.out.printf("linkedListStack测试-栈，栈的最大容量为%d\n", linkedListStack.maxSize);
        boolean signal = true;
        while (signal) {
            System.out.print("\n请输入a->入栈，p->出栈，q->退出程序：");
            char index = scanner.next().charAt(0);
            switch (index){
                case 'a':
                    System.out.print("\n添加一个数：");
                    int pushNum = scanner.nextInt();
                    linkedListStack.add(pushNum);
                    linkedListStack.list();
                    break;
                case 'p':
                    System.out.println("\n从栈中取出一个数：");
                    int popNum;
                    try {
                        popNum = linkedListStack.pop();
                        System.out.println("\n取出的是：" + popNum);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    linkedListStack.list();
                    break;
                case 'q':
                    System.out.println("退出程序");
                    signal = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
