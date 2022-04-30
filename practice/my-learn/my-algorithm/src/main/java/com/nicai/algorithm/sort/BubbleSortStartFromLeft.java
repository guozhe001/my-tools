package com.nicai.algorithm.sort;

/**
 * MaoPaoSort
 * 冒泡排序-从左向右冒泡：
 * 1、从左边开始依此比较相邻两个数字的大小
 * 2、如果左边的数字比右边的数字大，则交换位置
 *
 * @author guozhe
 * @date 2020/08/14
 */
public class BubbleSortStartFromLeft extends AbstractBubbleSort {

    @Override
    public int[] sort(int[] nums) {
        // 循环n次
        for (int i = 0; i < nums.length; i++) {
            /*
             * 冒泡排序的规律：
             * 第一次循环比较n-1次
             * 第二次循环比较n-2次
             * 第三次循环比较n-3次
             *
             * 代码循环的规律：
             * i=0时，比较n-1次
             * i=1时，比较n-2次
             * i=2时，比较n-3次
             *
             * 结束比较的规律：
             * i=0时，比较到数组下标为n-1为止
             * i=1时，比较到数组下标为n-2为止
             * i=2时，比较到数组下标为n-3为止
             *
             */
            for (int j = 0; j < nums.length - i - 1; j++) {
                compareAndSwap(nums, j, j + 1);
            }
        }
        return nums;
    }

    @Override
    public String getName() {
        return "从左边开始的冒泡排序";
    }

}
