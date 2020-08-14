package com.nicai.algorithm.sort;

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
}
