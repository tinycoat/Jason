package com.dataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 逆波兰表达式：(3+4)*5-6 --> 3 4 + 5 * 6 -
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个逆波兰表达式(空格分隔)：");
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String item : strArray) {
            if (isNum(item.charAt(0))) {
                stack.push(Integer.parseInt(item));
            }
            if (isOper(item.charAt(0))) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(cal(num2, num1, item.charAt(0)));
            }
        }
        System.out.print("计算结果为：" + stack.pop());
    }

    public static boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static int cal(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }
}
