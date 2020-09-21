package com.nicai.algorithm.datastructure;

import java.util.Iterator;

/**
 * 背包，集合
 * 此类为《算法（第4版）》中1.3.1的定义的实现类
 *
 * @author guozhe
 * @date 2020/09/19
 */
public class Bag<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * 添加一个元素
     */
    public void add(T item) {

    }

    /**
     * 背包是否为空
     *
     * @return 如果背包为空，则返回true，否则返回false
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * 背包中的元素数量
     *
     * @return 背包中的元素数量
     */
    public int size() {
        return 0;
    }

}
