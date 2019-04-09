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

    public static int[] bubbleSortOptimize(int[] nums){
        int count = 0;
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }

        boolean didSwap;
        int len = nums.length;
        int pos = 0;// 记录最后一次交换的位置
        int k = len - 1;
        for(int i = 0; i < len - 1; i++) {
            didSwap = false;
            for(int j = 0; j < k; j++) {
                if(nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //有交换即为true
                    didSwap = true;
                    pos = j;
                }
                count++;
            }
            if(!didSwap){
                //没发生交换说明有序了
                break;
            }
            k = pos;//最后交换位置赋值给k
        }
        System.out.println("bibbleSortOptimize循环次数为：" + count);
        return nums;
    }

}
