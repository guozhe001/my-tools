package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Queue;
import com.nicai.exception.NicaiException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 固定大小的队列：1.3.14
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class FixedCapacityQueue<T> implements Queue<T> {

    /**
     * 保存队列元素的数组
     */
    Object[] items;
    /**
     * 当前数组使用的容量
     */
    private int capacity;

    private int index;

    public FixedCapacityQueue(int size) {
        items = new Object[size];
        this.capacity = 0;
        this.index = 0;
    }

    @Override
    public void enqueue(T item) {
        if (capacity < items.length) {
            items[capacity++] = item;
        } else {
            throw new NicaiException("Queue is full");
        }
    }

    @Override
    public T dequeue() {
        if (index < capacity) {
            return (T) items[index++];
        } else {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < capacity;
        }

        @Override
        public T next() {
            if (index >= capacity) {
                throw new NoSuchElementException();
            }
            return (T) items[index++];
        }
    }

}
