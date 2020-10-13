package com.nicai.algorithm.algs4.practice.one;

/**
 * 一个以栈为目标的队列
 * 1.3.32 Steque。一个以栈为目标的队列（或称steque），是一种支持push、pop和enqueue操作的数据类型。为这种抽象数据类型定义一份API并给出一份基于链表的实现。
 * <p>
 *
 * @author guozhe
 * @date 2020/10/13
 */
public interface Steque<T> {

    /**
     * 在队尾压入一个元素
     *
     * @param item 元素
     */
    void push(T item);

    /**
     * 弹出一个元素
     *
     * @return 栈顶的元素
     */
    T pop();

    /**
     * 把元素放入队头
     *
     * @param item 元素
     */
    void enqueue(T item);

    /**
     * 当前队列的大小
     *
     * @return 当前队列的大小
     */
    int size();

    /**
     * 当前队列是否为空
     *
     * @return 当前队列为空返回true，否则返回false
     */
    boolean isEmpty();
}
