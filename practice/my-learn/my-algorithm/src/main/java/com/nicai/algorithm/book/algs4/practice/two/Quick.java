package com.nicai.algorithm.book.algs4.practice.two;

/**
 * 快速排序
 *
 * @author guozhe
 * @date 2020/12/01
 */
public class Quick<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] comparableArray) {
        sort(comparableArray, 0, comparableArray.length - 1);
    }

    // TODO 未完成
    private void sort(T[] comparableArray, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(comparableArray, lo, hi);
        sort(comparableArray, lo, j);
        sort(comparableArray, j + 1, hi);
    }

    private int partition(T[] comparableArray, int lo, int hi) {
        T v = comparableArray[lo];
        int i = lo;
        int j = hi;
        while (true) {
            while (less(comparableArray[i++], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, comparableArray[j--])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(comparableArray, i, j);
        }
        exch(comparableArray, lo, j);
        return j;
    }
}
