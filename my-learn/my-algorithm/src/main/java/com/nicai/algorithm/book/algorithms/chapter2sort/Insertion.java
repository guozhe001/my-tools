package com.nicai.algorithm.book.algorithms.chapter2sort;

/**
 * 插入排序，前面的数组永远是有序的
 *
 * @author nicai
 * @date 2020/12/1
 */
public class Insertion<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] comparableArray) {
        for (int i = 1; i < comparableArray.length; i++) {
            // 每次和前一个值比较，如果当前值小于前一个值，则交换位置
            for (int j = i; j > 0 && less(comparableArray[j], comparableArray[j - 1]); j--) {
                exch(comparableArray, j, j - 1);
            }
        }
    }
}
