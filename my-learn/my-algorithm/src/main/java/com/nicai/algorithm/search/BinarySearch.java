package com.nicai.algorithm.search;

import com.nicai.algorithm.sort.FastSort;

import java.util.Optional;

/**
 * @author guozhe
 * @date 2020/08/19
 */
public class BinarySearch implements Search {

    @Override
    public Optional<Integer> search(int[] array, int value) {
        int[] sorted = new FastSort().sort(array);
        return binarySearch(sorted, value);
    }


    private Optional<Integer> binarySearch(int[] array, int value) {
        /*
         * 0、如果array的长度等于0，则返回 Optional.empty()
         * 0、如果array的长度等于1，return array[0] == value ? 0 : Optional.empty()
         * 1、取中间的值
         * 2、与value比较
         * 3、如果value等于此值，则返回下标
         * 4、如果value小于此值，则继续在前面的数组使用二分查找
         * 5、如果value大于此值，则
         */
        return Optional.empty();
    }

}
