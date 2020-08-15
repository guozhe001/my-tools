package com.nicai.algorithm.sort;

import org.slf4j.Logger;

import java.util.Arrays;

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
        int[] numsCopy = Arrays.copyOfRange(nums, 0, nums.length);
        getLogger().info("source nums={}", nums);
        getLogger().info("sort name = {}=====================================================", getName());
        int[] sorted = sort(numsCopy);
        getLogger().info("sorted nums={}", sorted);
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
}
