package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename QuickSort</p>
 * <p>
 * <p>@description 快速排序Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/4/8 15:56
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95,101};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("已排序数组：" + Arrays.toString(nums));
    }

    /**
     * 经典快排(单轴快排)
     *
     * @param nums   待排数组
     * @param left   左侧开始位置
     * @param right  右侧结束位置
     */
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);

        //递归调用
        if(pivot == nums.length-1){
            quickSort(nums, left, pivot - 1);
        }else if(pivot == 0){
            quickSort(nums, pivot + 1, right);
        }else{
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }

    }

    /**
     *
     *
     * @param nums     待分区数组
     * @param left     左侧开始位置
     * @param right    右侧结束位置
     * @return         pivot位置
     */
    public static int partition(int[] nums, int left, int right){
        //取数组最后的值为轴
        int pivot = nums[right];
        int leftPointer = left;
        int rightPointer = right - 1;


        while(leftPointer < rightPointer){
            while(leftPointer < rightPointer && nums[leftPointer] <= pivot){
                leftPointer++;
            }
            while(leftPointer < rightPointer && nums[rightPointer] > pivot){
                rightPointer--;
            }
            if(leftPointer < rightPointer){
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
            }
        }

        if(nums[leftPointer] > pivot) {
            int temp = nums[leftPointer];
            nums[leftPointer] = pivot;
            nums[right] = temp;
            return leftPointer;
        }else{
            return right;
        }

    }

}
