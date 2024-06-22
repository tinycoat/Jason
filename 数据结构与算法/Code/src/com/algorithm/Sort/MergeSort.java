package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));

        // 速度测试
        int[] arr = new int[80000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成一个[0,80000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted1 = simpleDateFormat.format(date1);
        System.out.println("排序前：" + formatted1);

        mergeSort(arr, 0, arr.length - 1, temp);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序后：" + formatted2);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; // 中间索引
            // 向左递归分解 [left, mid]
            mergeSort(arr, left, mid, temp);
            // 向右递归分解 [mid + 1, right]
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     *
     * @param arr 原始数组
     * @param left  左边序列初始索引
     * @param mid   中间索引
     * @param right 右侧索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 左边有序序列的初始索引
        int j = mid + 1; // 右边有序序列的初始索引
        int t = 0; // 指向中转数组的当前索引

        // 将数据存入中转数组，直到左右某一序列遍历结束
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) { // 左边序列较小，填入中转数组
                temp[t] = arr[i];
                t++;
                i++;
            } else { // 右边序列较小，填入中转数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 将另一序列剩余部分拷贝至中转数组
        while (i <= mid) { // 左序列有剩余，填入
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) { // 右序列有剩余，填入
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 将中转数组拷贝至arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
