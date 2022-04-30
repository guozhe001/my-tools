package com.nicai.algorithm.book.algs4.practice.two;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author guozhe
 * @date 2020/12/01
 */
public class Merge<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] a) {
        // TODO 未完成，报java.lang.StackOverflowError
        sort(a, 0, a.length - 1);
    }

    /**
     * 对指定下标范围的数组排序
     *
     * @param a  待排序的数组
     * @param lo 最小的下标
     * @param hi 最大的下标
     */
    private void sort(T[] a, int lo, int hi) {
        T[] aux = Arrays.copyOf(a, a.length);
        if (hi - lo < 1) {
            return;
        }
        int mid = lo + (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi, aux);
    }

    /**
     * 原地归并
     */
    private void merge(T[] a, int lo, int mid, int hi, T[] aux) {
        // algs4中是把a[lo, hi]复制到aux[lo, hi]；此处为了简单是把a的所有元素复制到了aux中
        int i = lo;
        int j = mid + 1;
        // for循环中的k是用来定位a的位置；归并回到a[lo, hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
