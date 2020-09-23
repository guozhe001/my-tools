package com.nicai.algorithm.datastructure.impl;


import com.nicai.algorithm.datastructure.Stack;

import java.util.Iterator;

/**
 * StackImpl
 *
 * @author guozhe
 * @date 2020/09/23
 */
public class StackImpl<T> implements Stack<T> {

    /**
     * 栈的顶端，即链表的开始节点
     */
    private ListNode<T> first;

    /**
     * 栈的大小
     */
    private int size;

    @Override
    public void push(T item) {
        ListNode<T> oldFirst = first;
        first = new ListNode<>(item);
        first.next = oldFirst;
        size++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    // TODO
    private class StackIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }


    /**
     * 链表节点
     *
     * @param <T> 节点保存的元素类型
     */
    private class ListNode<T> {
        /**
         * 当前节点的元素
         */
        T item;

        /**
         * 下一个节点
         */
        ListNode<T> next;

        ListNode(T item) {
            this.item = item;
        }

    }
}
