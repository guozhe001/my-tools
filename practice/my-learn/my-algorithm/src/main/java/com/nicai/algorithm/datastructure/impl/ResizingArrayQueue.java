package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态扩展数组大小的队列实现：1.3.14
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class ResizingArrayQueue<T> implements Queue<T> {

    /**
     * 保存队列元素的数组
     */
    Object[] items;
    /**
     * 当前数组使用的容量
     */
    private int capacity;
    /**
     * 访问队列的下标
     */
    private int index;

    public ResizingArrayQueue() {
        items = new Object[2];
        this.capacity = 0;
        this.index = 0;
    }

    @Override
    public void enqueue(T item) {
        if (capacity == items.length) {
            resize(2 * items.length);
        }
        items[capacity++] = item;
    }

    private void resize(int newSize) {
        Object[] newItems = new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, Math.min(newSize, items.length));
        items = newItems;
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
