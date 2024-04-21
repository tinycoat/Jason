package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
//        int[] originNums = {101, 34, 119, 1};
//        System.out.println("原数组：" + Arrays.toString(originNums));
//        selectSort(originNums, true);

        // 选择排序速度测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成一个[0,80000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted1 = simpleDateFormat.format(date1);
        System.out.println("排序前：" + formatted1);

        selectSort(arr, false);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序后：" + formatted2);

    }

    public static void selectSort(int[] nums, boolean needShowProgress) {
        for (int i = 0; i < nums.length - 1; i++) { // 需要排序n-1轮
            int minIndex = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) { // 每次排出最小的数放在相应位置
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
            if (needShowProgress) {
                System.out.printf("第%d轮排序：" + Arrays.toString(nums) + '\n', i + 1);
            }
        }
    }
}
