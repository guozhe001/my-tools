package com.nicai.algorithm.search;

import cn.hutool.core.util.ArrayUtil;

import java.util.Optional;

/**
 * AbSearch
 *
 * @author guozhe
 * @date 2020/08/20
 */
public abstract class AbstractSearch implements Search {

    @Override
    public Optional<Integer> search(int[] array, int value) {
        if (ArrayUtil.isEmpty(array)) {
            return Optional.empty();
        }
        check(array);
        return search(array, 0, array.length - 1, value);
    }

    /**
     * 在指定的范围内查找
     *
     * @param array    数组
     * @param minIndex 较小的下标
     * @param maxIndex 较大的下标
     * @param value    待查找的值
     * @return 查询的结果, 目标数字所在的位置
     */
    abstract Optional<Integer> search(int[] array, int minIndex, int maxIndex, int value);

    /**
     * 检查数组是否满足查找的条件
     *
     * @param array 待查找的数组
     */
    abstract void check(int[] array);

}
