package com.nicai.algorithm.datastructure;

/**
 * 背包，集合
 * 此类为《算法（第4版）》中1.3.1的定义的实现类
 *
 * @author guozhe
 * @date 2020/09/19
 */
public interface Bag<T> extends Iterable<T> {

    /**
     * 添加一个元素
     *
     * @param item 待添加的元素
     */
    void add(T item);

    /**
     * 背包是否为空
     *
     * @return 如果背包为空，则返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 背包中的元素数量
     *
     * @return 背包中的元素数量
     */
    int size();

}
