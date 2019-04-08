package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename MergeSort</p>
 * <p>
 * <p>@description 归并排序Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/4/4 11:04
 **/
public class MergeSort {

    public static void main(String[] args) {
        //测试merge方法
        //int[] arr = new int[]{3,5,7,9,1,4,8};
        //merge(arr, 0, 4, 6);
        //System.out.println(Arrays.toString(arr));
        //arr = new int[]{3,5,7,9,1,4,8};
        //merge(arr, 1, 4, 5);
        //System.out.println(Arrays.toString(arr));

        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("已排序数组：" + Arrays.toString(nums));
    }

    /**
     * mergeSort
     *
     * @param nums        数组
     * @param left        开始位置
     * @param rightBound  结束位置
     */
    public static void mergeSort(int[] nums, int left, int rightBound){
        int mid = left + (rightBound - left) / 2;
        //递归结束条件
        if(left == rightBound) {
            return;
        }
        //左边
        mergeSort(nums, left, mid);

        //右边
        mergeSort(nums, mid + 1, rightBound);

        merge(nums, left, mid + 1, rightBound);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 二路归并
     * 原理：将两个有序表合并和一个有序表
     *
     * @param nums       原数组
     * @param left       左侧开始位置（第一个有序表开始位置）
     * @param right      右侧开始位置（第二个有序表开始位置）
     * @param rightBound 右侧结束位置（第二个有序表结束位置）
     */
    public static void merge(int[] nums, int left, int right, int rightBound){
        int[] temp = new int[rightBound - left + 1];
        int i = left, j = right, k = 0;
        while(i < right && j <= rightBound){
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while(i < right){
            temp[k++] = nums[i++];
        }

        while(j <= rightBound){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

}
