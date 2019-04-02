package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename InsertionSort</p>
 * <p>
 * <p>@description 插入排序Java实现:直接插入排序,二分插入排序</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/3/22 14:26
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = binaryInsertSort(nums);
        //int[] result = insertionSort(nums);
        //int[] result = insertionSort1(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int[] insertionSort(int[] nums){
        if(null == nums || nums.length < 2){
            System.out.println("输入的数组为空或者长度小于2 !");
            return null;
        }
        int count = 0;
        //第0位独自作为有序数列，从第1位开始向后遍历
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                count++;
            }
        }
        System.out.println("insertionSort，循环次数：" + count);
        return nums;
    }


    /**
     * 插入排序(改进)
     *
     * @param nums
     * @return
     */
    public static int[] insertionSort1(int[] nums){
        if(null == nums || nums.length < 2){
            System.out.println("输入的数组为空或者长度小于2 !");
            return null;
        }
        int count = 0;
        //第0位独自作为有序数列，从第1位开始向后遍历
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]) {
                int temp = nums[i];
                int k = i - 1;
                for(int j = k; j >= 0 && temp < nums[j]; j--){ //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                    nums[j+1] = nums[j];
                    k--;
                    count++;
                }
                nums[k+1] = temp; //插入第i位的值
            }
        }

        System.out.println("insertionSort1，循环次数：" + count);
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
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            for(int j = i - 1; j >= low; j--) {
                nums[j + 1] = nums[j];
            }
            nums[low] = temp;
        }
        return nums;
    }

}
