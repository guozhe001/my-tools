package com.nicai.algorithm.search;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * 二分查找
 *
 * @author guozhe
 * @date 2020/08/19
 */
@Slf4j
public class BinarySearch extends AbstractSearch {

    @Override
    void check(int[] array) {
        log.info("i'm BinarySearch，check array is sorted");
        for (int i = 0; i < array.length - 1; i++) {
            Assert.isTrue(array[i] <= array[i + 1]);
        }
    }

    /**
     * 使用二分法查找,传入的数组长度必须大于0
     * 会在最小下标和最大下标之间查找
     * 如果是查找整个数组，minIndex传入0，maxIndex传入array.length-1
     *
     * @param array    查询的范围：数组
     * @param minIndex 较小的下标
     * @param maxIndex 较大的下标
     * @param value    查询的目标：数字
     * @return 查询的结果, 目标数字所在的位置
     */
    @Override
    Optional<Integer> search(int[] array, int minIndex, int maxIndex, int value) {
        /*
         * 0、如果array的长度等于1，return array[0] == value ? 0 : Optional.empty()
         * 1、取中间的值
         * 2、与value比较
         * 3、如果value等于此值，则返回下标
         * 4、如果value小于此值，则继续在前面的数组使用二分查找
         * 5、如果value大于此值，则
         */
        // 如果传入的最小下标大于最大的下标，说明没有查询到，返回空
        if (minIndex > maxIndex) {
            return Optional.empty();
        }
        // 获取中间的下标
        int midIndex = (minIndex + maxIndex) / 2;
        int midValue = array[midIndex];
        log.info("midIndex={}, midValue={}, value={}", midIndex, midValue, value);
        if (midValue == value) {
            return Optional.of(midIndex);
        } else {
            // 如果中间值小于查找的值，则继续在中间值后面的范围查找; 否则继续在中间值前面的范围查找
            return midValue < value ? search(array, midIndex + 1, maxIndex, value) : search(array, minIndex, maxIndex - 1, value);
        }
    }

}
