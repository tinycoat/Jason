package com.algorithm.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("原数组：" + Arrays.toString(arr) + "\n");
        shell_exchange(arr);
    }

    public static void shell_exchange(int[] arr) {
        int temp = 0;
        int num = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) { // 原数组分为i个小组(每i个数据取一次)，不断分组，每次的分组个数为前一次的1/2
            num++;
            for (int j = i; j < arr.length; j++) { // 从小组长度处开始遍历
                for (int k = j - i; k >= 0; k -= i) { // 小组内从i处向前遍历
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                        System.out.println("交换 " + k + " 和 " + (k + i) + " 位置元素：" + Arrays.toString(arr));
                    }
                }
            }
            System.out.println("\n第" + num + "次排序(分" + i + "组，每组"+ arr.length / i +"个元素)" + Arrays.toString(arr) + "\n");
        }
    }
}
