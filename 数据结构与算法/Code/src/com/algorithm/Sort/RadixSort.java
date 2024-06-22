package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {

//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);
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

        radixSort(arr);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序后：" + formatted2);
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length]; // 定义一个二维数组表示10个桶，每个桶是一个一维数组
        int[] count = new int[10]; // 定义一个一维数组，表示每个桶存放了多少个数据
        // 找到最大位数
        int max = arr[0];
        for (int num : arr) { if (num > max) { max = num; } }
        int maxLength = (max + "").length();
        // 从低位到高位进行分桶排序
        for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
            for (int i = 0; i < arr.length; i++) { // 遍历原数组
                int digitOfElement = arr[i] / n % 10; // 取某数位的值
                bucket[digitOfElement][count[digitOfElement]] = arr[i]; // 装入对应的桶中
                count[digitOfElement]++; // 对应桶的存放数量+1
            }
            // 按桶的顺序取出，复制到原数组
            int index = 0;
            for (int x = 0; x < 10; x++) { // 遍历每个桶
                if (count[x] != 0) {
                    for (int y = 0; y < count[x]; y++) { // 按照count数量依次取出
                        arr[index] = bucket[x][y];
                        index++;
                    }
                    count[x] = 0; // 复制到原数组后一定要清零
                }
            }
        }
    }
}
