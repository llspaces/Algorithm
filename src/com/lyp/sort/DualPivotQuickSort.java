package com.lyp.sort;

import java.util.Arrays;

/**
 * <p>@filename DoublePivotQuickSort</p>
 * <p>
 * <p>@description 双轴快排Java实现</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2019/4/16 11:06
 **/
public class DualPivotQuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{30,100,34,52,6,8,78,95,101,66};
        System.out.println("待排序数组：" + Arrays.toString(nums));
        dualPivotQuickSort(nums, 0, nums.length - 1);
        System.out.println("已排序数组：" + Arrays.toString(nums));
    }

    /**
    * 双轴快排
    *
    * @param nums 待排数组
    * @param left 左侧开始位置
    * @param right 右侧结束位置
    */
    public static void dualPivotQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
          return;
        }

        //保证pivot1 <= pivot2
        if(nums[left] > nums[right]){
            swap(nums, left, right);
        }

        //取开始和结束位置作为双轴
        int pivot1 = nums[left];
        int pivot2 = nums[right];

        int i = left + 1;
        int k = left + 1;
        int j = right - 1;

        while(k <= j){
            if(nums[k] < pivot1){
                swap(nums, i, k);
                k++;
                i++;
            }else if(nums[k] >= pivot1 && nums[k] <= pivot2){
                k++;
            }else{
                while(nums[j] > pivot2){
                    if(j <= k){
                        //当k和j错过
                        break;
                    }
                    j--;
                }
                if(nums[j] >= pivot1 && nums[j] <= pivot2){
                    swap(nums, k, j);
                    k++;
                    j--;
                }else{
                    //注意k不动
                    swap(nums, j, k);
                    j--;
                }
            }
        }
        i--;
        j++;
        //将pivot1交换到适当位置
        swap(nums, left, i);
        //将pivot2交换到适当位置
        swap(nums, right, j);

        //一次双轴切分至少确定两个元素的位置，这两个元素将整个数组区间分成三份
        dualPivotQuickSort(nums, left, i-1);
        dualPivotQuickSort(nums, i+1, j-1);
        dualPivotQuickSort(nums, j+1, right);

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
