package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename BubbleSort</p>
 * <p>
 * <p>@description 冒泡排序Java实现</p>
 *
 * @author ylp729
 * @version 1.0
 * @since 2019/3/21 11:21
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = bubbleSort(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }

    public static int[] bubbleSort(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        long start = System.currentTimeMillis();
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序完成，耗时：" + (end - start) +"ms.");
        return nums;
    }


}
