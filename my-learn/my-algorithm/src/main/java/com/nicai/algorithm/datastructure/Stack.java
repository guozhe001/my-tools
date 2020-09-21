package com.nicai.algorithm.datastructure;

import java.util.Iterator;

/**
 * 下压（后进先出，LIFO）栈
 *
 * @author guozhe
 * @date 2020/09/19
 */
public class Stack<T> implements Iterable<T> {


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * 添加一个元素
     *
     * @param item 待添加的元素
     */
    public void push(T item) {
    }

    /**
     * 删除最近添加的元素并返回
     *
     * @return 最近添加的元素
     */
    public T pop() {
        return null;
    }

    /**
     * 栈是否为空
     *
     * @return 如果栈为空返回true，否则返回false
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * 栈中元素的数量
     *
     * @return 栈中元素的数量
     */
    public int size() {
        return 0;
    }
}
