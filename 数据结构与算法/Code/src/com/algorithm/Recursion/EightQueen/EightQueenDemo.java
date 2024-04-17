package com.algorithm.Recursion.EightQueen;

public class EightQueenDemo {
    private static final int sum = 8;
    private static final int[] array = new int[sum];
    private static int count = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.printf("\n共%d种解法\n", count);
    }

    // 算法
    private static void solve(int n) {
        if (n == sum) {
            printSolution();
            return;
        }
        // 尝试放置皇后
        for (int i = 0; i < sum; i++) {
            array[n] = i;
            if (judge(n)) {
                // 如果放在这里合理，继续找下一个合理的位置
                solve(n + 1);
            }
            // 如果不合理或者已经完成solve，换下一个位置
        }
    }

    // 判断放置第n个皇后是否合理
    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 打印放置情况
    private static void printSolution() {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        count++;
    }
}
