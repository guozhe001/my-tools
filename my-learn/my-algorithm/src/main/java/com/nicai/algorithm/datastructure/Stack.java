package com.nicai.algorithm.datastructure;

/**
 * 栈
 *
 * @author guozhe
 * @date 2020/09/21
 */
public interface Stack<T> {
    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    int size();

    void push(T item);

    T pop();
}
