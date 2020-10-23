package com.nicai.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * 选择排序：
 * 1、遍历数组，找到最小的数字，与第一个数字交换位置；比较次数=n-1
 * 2、遍历剩余的数组，找到最小的数字，与剩余数组的第一个数字交换位置；比较次数=n-2
 * <p>
 * 时间复杂度：
 * 循环次数 * 每次循环的比较次数 = n * ((n-1) + (n-2) + (n-3) + (n-4) + 2 + 1) = n * n/2 = n²/2 = n²
 * 循环次数：n
 * 每次循环比较次数：(n-1) + (n-2) + (n-3) + (n-4) + 2 + 1
 * 第一次循环：比较n-1次
 * 第二次循环：比较n-2次
 * 第三次循环：比较n-3次
 *
 * @author guozhe
 * @date 2020/08/14
 */
@Slf4j
public class SelectSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            /*
             * 比较数字的个数
             * i = 0时，在n个数字中查找最小数字
             * i = 1时，在n-1个数字中查找最小数字
             * i = 2时，在n-2个数字中查找最小数字
             * i = n-2时，在2个数字中查找最小数字
             *
             * i = 0时，比较的数字下标从0至n-1
             * i = 1时，比较的数字下标从1至n-1
             * i = 2时，比较的数字下标从2至n-1
             */
            // 定义当前循环的最小数字
            int minNum = nums[i];
            // 定义当前最小数字对应的下标
            int minNumIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                int currentNum = nums[j];
                if (currentNum < minNum) {
                    minNum = currentNum;
                    minNumIndex = j;
                }
            }
            // 如果最小数字的下标不是剩余数组的第一个的话，两个数字交换位置
            if (minNumIndex != i) {
                int temp = nums[i];
                nums[i] = minNum;
                nums[minNumIndex] = temp;
            }
        }
        return nums;
    }

    @Override
    public String getName() {
        return "插入排序";
    }


    @Override
    public Logger getLogger() {
        return log;
    }
}
