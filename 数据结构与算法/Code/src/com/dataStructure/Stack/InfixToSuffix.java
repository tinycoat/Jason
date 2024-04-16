package com.dataStructure.Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class InfixToSuffix {
    public static void main(String[] args) {
        // 实现中缀表达式转换成后缀表达式
        // 例如：1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        Scanner scanner = new Scanner(System.in);
        String infixStr = scanner.next();
        Stack<Character> s1 = new Stack<>(); // 符号栈
        // Stack<String> s2 = new Stack<>();
        // 由于s2无pop操作，而且最终还要逆序输出，所以可以不用栈来实现，用List即可
        ArrayList<String> s2 = new ArrayList<>();

        char[] infixStrCharArray = infixStr.toCharArray();
        int num = 0;
        // 遍历字符串
        for (char item : infixStrCharArray) {
            // 数字直接入栈
            if (item >= '0' && item <= '9') {
                num = num * 10 + (item - '0');
            } else if (item == '(') { // 左括号直接入栈s1
                if (num != 0) {
                    s2.add("" + num);
                    num = 0;
                }
                s1.push(item);
            } else if (item == ')') { // 消括号，把括号里的符号转移到s1
                if (num != 0) {
                    s2.add("" + num);
                    num = 0;
                }
                while (s1.peek() != '(') {
                    s2.add("" + s1.pop());
                }
                s1.pop(); // 将栈中的“)”弹出
            } else {   // 为符号时，比较优先级，保证从栈底到栈顶优先级递增
                if (num != 0) {
                    s2.add("" + num);
                    num = 0;
                }
                while (!s1.isEmpty() && priority(s1.peek()) >= priority(item)) {
                    s2.add("" + s1.pop());
                }
                s1.push(item);
            }
        }
        if (num != 0) {
            s2.add("" + num);
        }
        // 将剩余s1中符号添加入s2
        while (!s1.isEmpty()) {
            s2.add("" + s1.pop());
        }
        System.out.println(s2);
    }

    public static int priority(char ch) {
        int result = -1;
        switch (ch) {
            case '+', '-':
                result = 0;
                break;
            case '*', '/':
                result = 1;
                break;
            default:
                break;
        }
        return result;
    }
}
