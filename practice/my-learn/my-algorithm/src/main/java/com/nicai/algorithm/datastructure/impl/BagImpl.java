package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * BagImpl
 *
 * @author guozhe
 * @date 2020/09/28
 */
public class BagImpl<T> implements Bag<T> {

    /**
     * 链表的起始节点
     */
    private Node<T> first;
    /**
     * 当前bag的大小
     */
    private int n;

    @Override
    public void add(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * 链表迭代器
     */
    private class ListIterator implements Iterator<T> {
        private Node<T> first = BagImpl.this.first;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(first);
        }

        @Override
        public T next() {
            if (Objects.isNull(first)) {
                throw new NoSuchElementException();
            }
            T item = first.item;
            first = first.next;
            return item;
        }
    }

    /**
     * 链表的节点
     *
     * @param <T> 节点保存的数据类型
     */
    private static class Node<T> {
        /**
         * 节点的值
         */
        T item;
        /**
         * 下一个节点
         */
        Node<T> next;
    }
}
