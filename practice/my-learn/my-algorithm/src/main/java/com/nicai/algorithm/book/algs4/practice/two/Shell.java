package com.nicai.algorithm.book.algs4.practice.two;

/**
 * 希尔排序
 *
 * @author guozhe
 * @date 2020/12/01
 */
public class Shell<T extends Comparable<T>> implements Sort<T> {

    private static final int D = 3;

    @Override
    public void sort(T[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / D) {
            h = D * h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                for (int j = i; j > -h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / D;
        }
    }
}
