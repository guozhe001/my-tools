package com.nicai.algorithm.sort;

import cn.hutool.core.lang.Assert;

/**
 * AbstractBubbleSort-冒泡排序
 * 时间复杂度：
 * 循环次数 * 每次循环的比较次数 = n * ((n-1) + (n-2) + (n-3) + (n-4) + 2 + 1) = n * n/2 = n²/2 = n²
 * 循环次数：n
 * 每次循环的比较次数：(n-1) + (n-2) + (n-3) + (n-4) + 2 + 1
 * 第一次循环：n-1
 * 第二次循环：n-2
 * 第三次循环：n-3
 *
 * @author guozhe
 * @date 2020/08/14
 */
public abstract class AbstractBubbleSort implements Sort {

    /**
     * 比较指定的两个下标对应的数字，
     * 如果较小的下标的数字大于较大的小表对应的数字，则交换两个数字的位置
     *
     * @param nums       需要比较的数组
     * @param smallIndex 较小的下标
     * @param bigIndex   较大的下标
     */
    protected void compareAndSwap(int[] nums, int smallIndex, int bigIndex) {
        Assert.isTrue(smallIndex < bigIndex);
        int bigIndexNum = nums[bigIndex];
        int smallIndexNum = nums[smallIndex];
        if (bigIndexNum < smallIndexNum) {
            nums[bigIndex] = smallIndexNum;
            nums[smallIndex] = bigIndexNum;
        }
    }

}
