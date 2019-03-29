package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename SelectionSort</p>
 * <p>
 * <p>@description 选择排序Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/3/20 16:42
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = selectionSort(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }

    public static int[] selectionSort(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        long start = System.currentTimeMillis();
        int minPosition = 0;
        int temp = 0;
        for(int i = 0; i < nums.length - 1; i ++){
            minPosition = i;
            for(int j = i + 1; j < nums.length; j++ ){
                //在无序区中找到最小数据并保存其数组下标
                minPosition = nums[j] < nums[minPosition] ? j : minPosition;
                /*if(nums[j] < nums[minPosition]){
                    minPosition = j;
                }*/
            }
            //将最小元素放到本次循环的前端
            temp = nums[i];
            nums[i] = nums[minPosition];
            nums[minPosition] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序完成，耗时：" + (end - start) +"ms.");
        return nums;
    }

}
