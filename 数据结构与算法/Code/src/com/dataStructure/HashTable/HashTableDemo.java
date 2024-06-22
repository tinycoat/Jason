package com.dataStructure.HashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTable hashTable = new HashTable(7);
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        while (true) {
            System.out.println("add: 1");
            System.out.println("list: 2");
            System.out.println("find: 3");
            System.out.println("exit: 4");

            key = scanner.nextInt();

            switch (key) {
                case 1:
                    System.out.print("输入工号：");
                    int id = scanner.nextInt();
                    System.out.print("输入名字：");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case 2:
                    hashTable.list();
                    break;
                case 3:
                    System.out.print("输入工号：");
                    int empID = scanner.nextInt();
                    hashTable.findEmpById(empID);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }


        }

    }
}
