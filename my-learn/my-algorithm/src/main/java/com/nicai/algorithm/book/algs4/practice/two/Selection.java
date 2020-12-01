package com.nicai.algorithm.book.algs4.practice.two;

/**
 * 选择排序
 *
 * @author nicai
 * @date 2020/12/1
 */
public class Selection<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] comparableArray) {
        for (int i = 0; i < comparableArray.length; i++) {
            int min = i;
            for (int j = i; j < comparableArray.length; j++) {
                if (less(comparableArray[j], comparableArray[i])) {
                    min = j;
                }
            }
            exch(comparableArray, i, min);
        }
    }
}
