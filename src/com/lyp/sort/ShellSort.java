package com.lyp.sort;

import java.util.Arrays;
/**
 * <p>@filename ShellSort</p>
 * <p>
 * <p>@description 希尔排序(改进的插入排序)Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/4/2 14:26
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = shellSort2(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
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
        int count = 0;
        int len = nums.length;
        //增量gap
        int d = len / 2;

        while(d >= 1){
            for(int i = d; i < len; i++){
                //分组插入排序
                for(int j = i; j < len; j += d){
                    if(nums[j] < nums[j-d]){
                        int temp = nums[j];
                        nums[j] = nums[j-d];
                        nums[j-d] = temp;
                    }
                    count++;
                }
            }
            d = d / 2;
        }
        System.out.println("shellSort，循环次数：" + count);
        return nums;
    }

    /**
     * 希尔排序(优化插入1)
     *
     * @param nums
     * @return
     */
    public static int[] shellSort1(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        int count = 0;
        int len = nums.length;
        //增量gap
        int d = len / 2;

        while(d >= 1){
            for(int i = 0; i < d; i++){
                //分组插入排序
                for(int j = i + d; j < len; j += d){
                    int temp = nums[j];
                    int k;
                    //向后移位,直到找到小于nums[j]的
                    for(k = j - d; k >= 0 && nums[k] > temp; k -= d){
                        nums[k+d] = nums[k];
                        count++;
                    }
                    //插入nums[j]
                    nums[k+d] = temp;
                }
            }
            d = d / 2;
        }
        System.out.println("shellSort1，循环次数：" + count);
        return nums;
    }

    /**
     * 希尔排序(优化插入2)
     *
     * @param nums
     * @return
     */
    public static int[] shellSort2(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        int count = 0;
        int len = nums.length;
        //增量gap
        int d = len / 2;

        while(d >= 1){
            for(int i = d; i < len; i++){
                //分组插入排序
                if(nums[i] < nums[i-d]){
                    int temp = nums[i];
                    int k = i - d;
                    for(int j = k; j >= 0 && temp < nums[j]; j -= d){ //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                        nums[j+d] = nums[j];
                        k -= d;
                        count++;
                    }
                    nums[k+d] = temp; //插入第i位的值
                }
            }
            d = d / 2;
        }
        System.out.println("shellSort2，循环次数：" + count);
        return nums;
    }

}
