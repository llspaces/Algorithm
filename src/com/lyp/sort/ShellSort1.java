package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename ShellSort</p>
 * <p>
 * <p>@description 基于knuth序列的希尔排序Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/4/2 22:30
 **/
public class ShellSort1 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,34,52,6,8,78,95};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        int[] result = shellSortKnuth(nums);
        System.out.println("已排序数组：" + Arrays.toString(result));
    }

    /**
     * 基于knuth序列的希尔排序
     *
     * @param nums
     * @return
     */
    public static int[] shellSortKnuth(int[] nums){
        if(null == nums || nums.length == 0){
            System.out.println("输入的数组为空!");
            return null;
        }
        int count = 0;
        int len = nums.length;
        //增量序列
        int h = 1;
        while(h <= len /3){
            h = h * 3 + 1;
        }
        //将h赋值给d
        int d = h;
        for(; d > 0; d = (d - 1) / 3){
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
        }
        System.out.println("shellSortKnuth，循环次数：" + count);
        return nums;
    }
}
