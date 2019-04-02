package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename BubbleSort1</p>
 * <p>
 * <p>@description 冒泡排序优化</p>
 *
 * @author Java猿人一枚
 * @version 1.0
 * @since 2019/3/31
 **/
public class BubbleSort1 {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = bubbleSort(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }

    public static int[] bubbleSort(int[] nums){
        int count = 0;
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                count++;
            }
        }
        System.out.println("bubbleSortOld循环次数为：" + count);
        return nums;
    }

    public static int[] bibbleSortOptimize(int[] nums){
        int count = 0;
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }



        System.out.println("bibbleSortOptimize循环次数为：" + count);
        return nums;
    }

}
