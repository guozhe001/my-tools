package com.nicai.algorithm.sort;

import cn.hutool.core.lang.Assert;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Objects;

/**
 * Sort，把给定的数组进行排序
 * 约定如下：
 * 1、数组的长度为n
 * 2、结果是从小到大排序
 *
 * @author guozhe
 * @date 2020/08/14
 */
public interface Sort {

    default int[] sortAndPrint(int[] nums) {
        Objects.requireNonNull(nums);
        int[] numsCopy = Arrays.copyOfRange(nums, 0, nums.length);
        getLogger().info("sort name = {} start=====================================================", getName());
        getLogger().info("source nums={}", nums);
        int[] sorted = sort(numsCopy);
        getLogger().info("sorted nums={}", sorted);
        getLogger().info("sort name = {} end=======================================================", getName());
        return sorted;
    }

    /**
     * 对给定的数组进行排序
     *
     * @param nums 待排序的数组
     * @return 排好序的数组
     */
    int[] sort(int[] nums);

    /**
     * 获取当前排序算法的名字
     *
     * @return 排序算法的名字
     */
    String getName();

    /**
     * 获取日志打印
     *
     * @return 日志打印
     */
    Logger getLogger();

    /**
     * 比较指定的两个下标对应的数字，
     * 如果较小的下标的数字大于较大的小表对应的数字，则交换两个数字的位置
     *
     * @param nums       需要比较的数组
     * @param smallIndex 较小的下标
     * @param bigIndex   较大的下标
     */
    default void compareAndSwap(int[] nums, int smallIndex, int bigIndex) {
        Assert.isTrue(smallIndex < bigIndex);
        int bigIndexNum = nums[bigIndex];
        int smallIndexNum = nums[smallIndex];
        if (bigIndexNum < smallIndexNum) {
            nums[bigIndex] = smallIndexNum;
            nums[smallIndex] = bigIndexNum;
        }
    }
}
