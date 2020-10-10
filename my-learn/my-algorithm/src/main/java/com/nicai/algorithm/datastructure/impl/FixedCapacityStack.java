package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Stack;
import com.nicai.exception.NicaiException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 定容栈容量固定的栈
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class FixedCapacityStack<T> implements Stack<T> {

    /**
     * 保存集合的数组
     */
    private final T[] items;

    /**
     * 当前容量
     */
    private int capacity;

    public FixedCapacityStack(int size) {
        this.items = (T[]) new Object[size];
    }

    @Override
    public boolean isEmpty() {
        // 如果当前的容量为0，说明为空
        return capacity == 0;
    }

    @Override
    public int size() {
        // 当前容量就是大小
        return capacity;
    }

    @Override
    public T peek() {
        if (capacity > 0) {
            return items[capacity - 1];
        } else {
            throw new NoSuchElementException("栈已空，无法弹出元素");
        }
    }

    @Override
    public void push(T item) {
        // 如果当前的容量小于数组的长度，说明可以继续添加
        if (capacity < items.length) {
            items[capacity] = item;
            capacity++;
        } else {
            throw new NicaiException("栈已满，无法添加新的元素");
        }
    }

    @Override
    public T pop() {
        if (capacity > 0) {
            capacity--;
            return items[capacity];
        } else {
            throw new NoSuchElementException("栈已空，无法弹出元素");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public boolean isFull() {
        return capacity == items.length;
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
                throw new NoSuchElementException();
            }

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
