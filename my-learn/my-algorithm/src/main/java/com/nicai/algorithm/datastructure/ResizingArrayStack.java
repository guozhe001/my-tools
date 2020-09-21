package com.nicai.algorithm.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态调整数组大小的栈实现
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class ResizingArrayStack<T> implements Stack<T> {

    /**
     * 栈的初始化大小
     */
    private static final int INIT_SIZE = 1;
    /**
     * 调整大小的倍数
     */
    private static final int RESIZE_MULTIPLE = 2;
    /**
     * 允许总容量比使用容量的倍数
     */
    private static final int MIN_MULTIPLE = 4;
    /**
     * 元素数组
     */
    private T[] items;

    /**
     * 当前已经使用了多少容量
     */
    private int capacity;


    public ResizingArrayStack() {
        items = (T[]) new Object[INIT_SIZE];
    }

    @Override
    public void push(T item) {
        if (capacity == items.length) {
            resize(capacity * RESIZE_MULTIPLE);
        }
        items[capacity] = item;
        capacity++;
    }

    @Override
    public T pop() {
        capacity--;
        T item = items[capacity];
        // 如果容量只是用了四分之一，则调整数组大小
        if (capacity == items.length / MIN_MULTIPLE) {
            resize(items.length / RESIZE_MULTIPLE);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public int size() {
        return capacity;
    }

    /**
     * 调整数组大小
     *
     * @param newCapacity 新的数组容量
     */
    private void resize(int newCapacity) {
        T[] oldItems = items;
        items = (T[]) new Object[newCapacity];
        System.arraycopy(oldItems, 0, items, 0, Math.min(oldItems.length, newCapacity));
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = capacity;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (i > 0) {
                i--;
                return items[i];
            } else {
                throw new NoSuchElementException("stack is empty");
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
