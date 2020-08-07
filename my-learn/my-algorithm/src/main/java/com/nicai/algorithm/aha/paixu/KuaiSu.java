package com.nicai.algorithm.aha.paixu;

import java.util.Arrays;

/**
 * 快速排序：
 * 基线条件是什么：
 * 数组中只有一个值或者没有值，直接返回这个数组；
 * 递归条件：
 * 数组中有两个值，则比较两个值的大小，然后进行交换
 * 数组中有三个值，找一个基准值，然后找出小于基准值的数组，然后找出大于基准值的数组，然后对小于基准值的数组排序 + 基准值 + 对大于基准值的数组排序
 *
 * @author guozhe
 * @date 2018/11/19
 */
public class KuaiSu extends Print implements Sort {
    /**
     * 快速排序
     *
     * @param a
     * @return
     */
    @Override
    public int[] sort(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int jizhun = a[0];
        // 小于的位置
        int xiaoyuPosion = 0;
        // 大于的位置
        int dayuPosion = 0;
        int[] xiaoyu = new int[a.length];
        int[] dayu = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= jizhun) {
                xiaoyu[xiaoyuPosion] = a[i];
                xiaoyuPosion++;
            } else {
                dayu[dayuPosion] = a[i];
                dayuPosion++;
            }
        }

        int[] result = new int[a.length];
        // System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)
        System.arraycopy(sort(Arrays.copyOf(xiaoyu, xiaoyuPosion)), 0, result, 0, xiaoyuPosion);
        result[xiaoyuPosion] = jizhun;
        System.arraycopy(sort(Arrays.copyOf(dayu, dayuPosion)), 0, result, xiaoyuPosion + 1, dayuPosion);
        return result;
    }

    @Override
    public int[] sort1(int[] a) {
        return new int[0];
    }
}
