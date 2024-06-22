package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, -2, -1, 0, -3};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        // 速度测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成一个[0,80000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted1 = simpleDateFormat.format(date1);
        System.out.println("排序前：" + formatted1);

        quickSort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序后：" + formatted2);

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;   // 左下标
        int r = right;  // 右下标
        int temp = 0;    // 用于临时交换
        int mid = arr[(left + right) / 2]; // 中轴元素
        while (l < r) { // 比mid值小的放左边，大的放右边
            while (arr[l] < mid) { // 左侧查找大于mid的值，最坏的情况l指向mid
                l++;
            }
            while (arr[r] > mid) { // 右侧找小于mid的值，最坏的情况r指向mid
                r--;
            }
            if (l >= r) { // 查找结束后发现已经满足左右各为较小较大的，终止
                break;
            }
            temp = arr[l];  // 左右值交换
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == mid) {    // 交换完发现左侧交换后的值为mid，右指针提前前移，防止出现死循环
                r--;
            }
            if (arr[r] == mid) {    // 交换完之后右侧交换的值为mid，左指针提前后移，防止出现死循环
                l++;
            }
        }

        if (l == r) {   // 为了防止无限递归，内存溢出
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
