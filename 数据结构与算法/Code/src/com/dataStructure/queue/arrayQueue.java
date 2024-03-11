package com.dataStructure.queue;


import java.util.Scanner;

public class arrayQueue {
    public static void main(String[] args) {
        myQueue queue = new myQueue(3);
        // 用于用户输入
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列的数据");
            System.out.println("e(exit): 退出程序队列");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("向队列取存入1个数字：");
                    int element = scanner.nextInt();
                    try {
                        queue.putElement(element);
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 'g':
                    System.out.println("从队列取取出1个数字");
                    try {
                        System.out.printf("从队列中取到了数字%d\n", queue.getElement());
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                case 'h':
                    System.out.println("查看队列头部数据");
                    try {
                        System.out.printf("当前队列的头部数据是%d", queue.showFirstElement());
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}
