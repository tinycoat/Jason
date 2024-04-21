package com.algorithm.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] originNums = {101, 34, 119, 1, -1, 89};
        System.out.println("排序前：" + Arrays.toString(originNums));
        insertSort(originNums, true);

        // 插入排序速度测试
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成一个[0,80000)的数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted1 = simpleDateFormat.format(date1);
        System.out.println("排序前：" + formatted1);

        insertSort(arr, false);

        Date date2 = new Date();
        String formatted2 = simpleDateFormat.format(date2);
        System.out.println("排序后：" + formatted2);
    }

    public static void insertSort(int[] nums, boolean needShowProgress) {
        for (int i = 1; i < nums.length; i++) { // {[有序列表],[无序列表]}，默认原数组第一个元素有序
            int insertIndex = i - 1;    // 从无序列表分界处前一个元素开始向前遍历
            int insertNum = nums[i];    // 缓存无序列表第一个元素
            while (insertIndex >= 0 && insertNum < nums[insertIndex]) { // 向前遍历，从小到大
                // 扩充有序列表，大的后移一位
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }
            // 找到第一个小于缓存元素的位置，在它的下一个位置添加缓存元素
            if (insertIndex + 1 != i) {
                nums[insertIndex + 1] = insertNum;
            }
            if (needShowProgress) {
                System.out.printf("第%d轮排序：" + Arrays.toString(nums) + "\n", i);
            }
        }
    }
}
