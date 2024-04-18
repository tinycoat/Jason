package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        bubbleSort(arr, true);
//        System.out.println("排序后：" + Arrays.toString(arr));

        // 测试时间复杂度
        int maxLength = 80000;
        int[] arr = new int[maxLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 80000)的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String formatted1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间：" + formatted1);

        bubbleSort(arr, false);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序前时间：" + formatted2);
    }

    public static void bubbleSort(int[] arr, boolean needShowProgress) {
        boolean isChanged = false;
        for (int i = 0; i < arr.length - 1; i++) {  // 共需要排 n-1 次
            for (int j = 0; j < arr.length - i - 1; j++) { // 每次比较次数减少
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            } else {
                isChanged = false;
            }
            if (needShowProgress) {
                System.out.printf("第%d轮排序后：" + Arrays.toString(arr) + '\n', i);
            }
        }
    }
}
