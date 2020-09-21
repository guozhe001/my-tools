package com.nicai.algorithm.datastructure;

/**
 * 下压（后进先出，LIFO）栈
 *
 * @author guozhe
 * @date 2020/09/19
 */
interface Stack<T> extends Iterable<T> {

    /**
     * 添加一个元素
     *
     * @param item 待添加的元素
     */
    void push(T item);

    /**
     * 删除最近添加的元素并返回
     *
     * @return 最近添加的元素
     */
    T pop();

    /**
     * 栈是否为空
     *
     * @return 如果栈为空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 栈中元素的数量
     *
     * @return 栈中元素的数量
     */
    int size();
}
