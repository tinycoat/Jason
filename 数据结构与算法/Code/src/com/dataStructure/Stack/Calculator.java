package com.dataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

// 使用Stack实现综合计算器们需要将原有类进行扩展
public class Calculator {
    public static void main(String[] args) {
        // 输入表达式并转成字符数组
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个表达式：");
        String str = scanner.next();
        char[] strArray = str.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        // 入栈的数字
        int num = 0;
        // 遍历输入的数组
        for (char item : strArray) {
            // 如果当前字符为操作符
            if (isOper(item)) {
                // 直到遇见符号，将前面存在num中的数字入栈
                if (num != 0) {
                    numStack.push(num);
                    num = 0;
                }
                // 如果栈为空，或者当前oper优先级高于栈顶oper，直接入栈
                if (operStack.isEmpty() || priority(item) >= priority(operStack.peek())) {
                    operStack.push(item);
                } else {
                    // 如果当前oper的优先级比栈顶oper更低，先算栈中一个运算，再将结果和oper入栈
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    char oper = operStack.pop();
                    numStack.push(cal(num1, num2, oper));
                    operStack.push(item);
                }
            }
            // 如果当前字符为数字，更新num
            if (isNum(item)) {
                num = num * 10 + item - 48;
            }
        }
        // 遍历结束后，因为不会再遇见符号，所以要存入最后一个数字
        if (num != 0) {
            numStack.push(num);
        }
        // 将入栈的数字和操作进行计算，注意两个数前后先num2后num1
        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = operStack.pop();
            numStack.push(cal(num1, num2, oper));
        }
        // 最终数栈中仅剩一个数
        System.out.println("最终结果为：" + numStack.pop());
    }

    public static boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static int priority(char oper) {
        if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '*' || oper == '/') {
            return 1;
        } else {
            return -1;
        }
    }

    public static int cal(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
