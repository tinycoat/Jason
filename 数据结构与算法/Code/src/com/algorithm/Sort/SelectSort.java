package com.algorithm.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] originNums = {101, 34, 119, 1};
        System.out.println("原数组：" + Arrays.toString(originNums));
        selectSort(originNums, true);
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
