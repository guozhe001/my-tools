package com.nicai.algorithm.book.algs4.practice.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序接口
 *
 * @author nicai
 * @date 2020/12/1
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 对数组做排序
     *
     * @param comparableArray 待排序的数组
     */
    void sort(T[] comparableArray);

    /**
     * 判断v是否小于w，如果v小于w则返回true，否则返回false
     *
     * @param v 待比较的v
     * @param w 待比较的w
     * @return 如果v小于w则返回true，否则返回false
     */
    default boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换指定的i和j位置的值
     *
     * @param comparableArray 数组
     * @param i               位置i
     * @param j               位置j
     */
    default void exch(Comparable<T>[] comparableArray, int i, int j) {
        Comparable<T> temp = comparableArray[i];
        comparableArray[i] = comparableArray[j];
        comparableArray[j] = temp;
    }

    /**
     * 打印
     *
     * @param comparableArray 可比较的数组
     */
    default void show(Comparable<T>[] comparableArray) {
        for (Comparable<T> comparable : comparableArray) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }

    /**
     * 判断数组是否是有序的（从小到大排序）
     *
     * @param comparableArray 可比较的数组
     * @return 如果是有序的返回true，否则返回false
     */
    default boolean isSorted(T[] comparableArray) {
        for (int i = 0; i < comparableArray.length - 1; i++) {
            if (!less(comparableArray[i], comparableArray[i + 1])) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
