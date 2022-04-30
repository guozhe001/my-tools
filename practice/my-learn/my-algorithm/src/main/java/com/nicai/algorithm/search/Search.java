package com.nicai.algorithm.search;

import java.util.Optional;

/**
 * 查找接口
 *
 * @author guozhe
 * @date 2020/08/19
 */
public interface Search {

    /**
     * 查询
     *
     * @param array 查询的范围：数组
     * @param value 查询的目标：数字
     * @return 查询的结果, 目标数字所在的位置
     */
    Optional<Integer> search(int[] array, int value);

}
