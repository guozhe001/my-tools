package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * FastSort
 * 快速排序:
 * 1、选择基准值，比如第一个位置的数字
 * 快速排序采用分而治之的思想
 * 如果数组中只有0个值，则不需要排序
 * 如果数组中只有1个值，则不需要排序
 * 如果数组中只有2个值，则比较两个值的大小
 *
 * @author guozhe
 * @date 2020/08/18
 */
@Slf4j
public class FastSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        // 如果数组中有1个或者0个元素，则不需要排序直接返回
        if (nums.length <= 1) {
            return nums;
        }
        // 如果数组中的元素有2个
        if (2 == nums.length) {
            compareAndSwap(nums, 0, 1);
            return nums;
        }
        // 如果数组中的元素大于2，选择第一个为基准值，把小于基准值的找出来进行排序，并放在基准值的左边；把大于基准值的找出来进行排序，并放在基准值的右边
        int pivot = nums[0];
        // 比基准值小的数组，总长度为原来的数组长度
        int[] smallThanPivot = new int[nums.length];
        // 记录比基准值小的数组当前的下标
        int smallThanPivotIndex = 0;
        // 比基准值大的数组
        int[] bigOrEqualThanPivot = new int[nums.length];
        int bigOrEqualThanPivotIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pivot) {
                smallThanPivot[smallThanPivotIndex] = nums[i];
                // 比基准值小的数组自增1
                smallThanPivotIndex++;
            } else {
                bigOrEqualThanPivot[bigOrEqualThanPivotIndex] = nums[i];
                bigOrEqualThanPivotIndex++;
            }
        }
        return merge(sort(Arrays.copyOfRange(smallThanPivot, 0, smallThanPivotIndex)), new int[]{pivot}, sort(Arrays.copyOfRange(bigOrEqualThanPivot, 0, bigOrEqualThanPivotIndex)));
    }

    /**
     * 数组拼接，按照先后顺序把多个数组拼接成一个新的数组
     * 如果数组特别大的话，会超过int的最大值
     *
     * @param arrays 需要拼接的数组
     */
    private int[] merge(int[]... arrays) {
        int newArrayLength = Arrays.stream(arrays).map(ints -> ints.length).reduce(Integer::sum).orElse(0);
        int[] newArray = new int[newArrayLength];
        int initIndex = 0;
        for (int[] array : arrays) {
            for (int item : array) {
                newArray[initIndex] = item;
                initIndex++;
            }
        }
        return newArray;
    }

    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}
