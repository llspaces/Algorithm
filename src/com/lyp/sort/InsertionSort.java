package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename InsertionSort</p>
 * <p>
 * <p>@description 插入排序Java实现:直接插入排序,二分插入排序,希尔排序</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/3/22 14:26
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = straightInsertionSort(nums);
        //int[] result = binaryInsertSort(nums);
        //int[] result = shellSort(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }




    /**
     * 直接插入排序
     *
     * @param nums
     * @return
     */
    public static int[] straightInsertionSort(int[] nums){
        if(null == nums || nums.length < 2){
            System.out.println("输入的数组为空或者长度小于2 !");
            return null;
        }
        long start = System.currentTimeMillis();
        //第0位独自作为有序数列，从第1位开始向后遍历
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]) {
                int temp = nums[i];
                int k = i - 1;
                for(int j = k; j >= 0 && temp < nums[j]; j--){
                    nums[j+1] = nums[j];
                    k--;
                }
                nums[k+1] = temp;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("直接插入排序完成，耗时：" + (end - start) +"ms.");
        return nums;
    }

    /**
     * 二分插入排序
     *
     * @param nums
     * @return
     */
    public static int[] binaryInsertSort(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("冒泡排序完成，耗时：" + (end - start) +"ms.");
        return nums;
    }

    /**
     * 希尔排序
     *
     * @param nums
     * @return
     */
    public static int[] shellSort(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("冒泡排序完成，耗时：" + (end - start) +"ms.");
        return nums;
    }

}
