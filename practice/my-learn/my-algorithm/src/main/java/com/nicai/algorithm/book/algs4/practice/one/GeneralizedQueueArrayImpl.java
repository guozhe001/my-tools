package com.nicai.algorithm.book.algs4.practice.one;

import cn.hutool.core.lang.Assert;

/**
 * 首先用数组实现该数据类型：GeneralizedQueue
 *
 * @author guozhe
 * @date 2020/10/14
 */
public class GeneralizedQueueArrayImpl<T> implements GeneralizedQueue<T> {

    /**
     * 保存队列元素的数组
     */
    private Object[] items;
    /**
     * 当前数组的容量
     */
    private int capacity;

    public GeneralizedQueueArrayImpl() {
        items = new Object[16];
        capacity = 0;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public void insert(T x) {
        if (capacity == items.length) {
            resize(capacity << 1);
        }
        items[capacity++] = x;
    }

    private void resize(int size) {
        Object[] newItems = new Object[size];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    @Override
    public T delete(int k) {
        Assert.isTrue(k > 0 && k <= capacity);
        T item = (T) items[k - 1];
        while (k - 1 < items.length - 1) {
            items[k - 1] = items[k];
            k++;
        }
        capacity--;
        return item;
    }
}
