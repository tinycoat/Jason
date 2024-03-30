package com.dataStructure.Queue;

import java.util.Scanner;

public class arrayQueueDemo {
    public static void main(String[] args) {
        // 用于用户输入
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean programLoop = true;
        while (programLoop) {
            System.out.println("选择队列类型：");
            System.out.println("  1.单向队列");
            System.out.println("  2.环形队列");
            System.out.println("退出程序（0）");
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    testQueue(scanner);
                    break;
                case 2:
                    testCircleQueue(scanner);
                    break;
                case 0:
                    scanner.close();
                    programLoop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出...");
    }

    public static void testQueue(Scanner scanner) {
        char key;
        boolean loop = true;
        myQueue queue = new myQueue(3);
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
                    break;
                case 'h':
                    System.out.println("查看队列头部数据");
                    try {
                        System.out.printf("当前队列的头部数据是%d\n", queue.showFirstElement());
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("队列程序退出...");
    }

    public static void testCircleQueue(Scanner scanner) {
        char key;
        boolean loop = true;
        myCircleQueue queue = new myCircleQueue(3);
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
                        queue.addElement(element);
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
                    break;
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
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("环形程序退出...");
    }
}
