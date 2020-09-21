package com.nicai.algorithm.datastructure;

import java.util.Iterator;

/**
 * 先进先出（FIFO）队列
 * 此类为《算法（第4版）》中1.3.1的API定义的实现类
 *
 * @author guozhe
 * @date 2020/09/19
 */
public class Queue<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * 添加一个元素
     *
     * @param item 需要添加的元素
     */
    public void enqueue(T item) {

    }

    /**
     * 删除最早添加的元素并返回
     *
     * @return 最早添加的元素
     */
    public T dequeue() {
        return null;
    }


    /**
     * 队列是否为空
     *
     * @return 如果队列为空，返回true，否则返回false
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * 队列中的元素数量
     *
     * @return 队列中的元素数量
     */
    public int size() {
        return 0;
    }

}
