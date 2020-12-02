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
    public void sort(T[] comparableArray) {
        sort(comparableArray, 0, comparableArray.length - 1);
    }

    /**
     * 对指定下标范围的数组排序
     *
     * @param comparableArray 待排序的数组
     * @param lo              最小的下标
     * @param hi              最大的下标
     */
    private void sort(T[] comparableArray, int lo, int hi) {
        if (hi - lo < 1) {
            return;
        }
        int mid = lo + (lo + hi) / 2;
        sort(comparableArray, lo, mid);
        sort(comparableArray, mid + 1, hi);
        merge(comparableArray, lo, mid, hi);
    }

    /**
     * 把[lo, mid]和[mid+1,hi]的两个数组合并成一个数组
     */
    private void merge(T[] a, int lo, int mid, int hi) {
        // algs4中是把a[lo, hi]复制到aux[lo, hi]；此处为了简单是把a的所有元素复制到了aux中
        T[] aux = Arrays.copyOf(a, a.length);
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
