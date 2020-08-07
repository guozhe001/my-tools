package com.nicai.algorithm.aha.paixu;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class KuaiSuTest {

    @Test
    public void sort() {
        Sort kuaisu = new KuaiSu();
        int[] sort = kuaisu.sort(new int[]{7, 5, 23, 7, 8, 10, 47, 36, 1, 3});
        log.info("sorted={}", sort);
    }

    @Test
    public void arraycopy() {
        int[] result = new int[9];
        // System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)
        System.arraycopy(new int[]{1, 2, 3, 4}, 0, result, 0, 4);
        result[4] = 5;
        System.arraycopy(new int[]{6, 7, 8, 9}, 0, result, 5, 4);
        log.info("result={}", result);
    }

}