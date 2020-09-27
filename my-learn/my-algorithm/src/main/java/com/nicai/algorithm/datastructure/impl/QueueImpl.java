package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * QueueImpl
 *
 * @author guozhe
 * @date 2020/09/27
 */
public class QueueImpl<T> implements Queue<T> {

    /**
     * 队列的第一个节点
     */
    private Node first;

    /**
     * 队列的最后一个节点
     */
    private Node end;

    /**
     * 队列的大小
     */
    private int size;

    @Override
    public void enqueue(T item) {
        Node node = new Node();
        node.item = item;
        // 如果队列的最后一个节点为null，说明整个队列为null
        if (Objects.isNull(end)) {
            first = node;
        } else {
            end.next = node;
        }
        end = node;
        size++;
    }

    @Override
    public T dequeue() {
        Node oldFirst = first;
        first = first.next;
        size--;
        return oldFirst.item;
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
        return new MyQueueIterator();
    }

    /**
     * 我的队列的迭代器
     */
    private class MyQueueIterator implements Iterator<T> {

        int i = size;
        Node node = first;

        @Override
        public boolean hasNext() {
            i--;
            return i >= 0;
        }

        @Override
        public T next() {
            if (Objects.isNull(node)) {
                throw new NoSuchElementException();
            }
            T item = node.item;
            node = node.next;
            return item;
        }
    }


    /**
     * 链表节点
     */
    private class Node {
        /**
         * 当前节点的值
         */
        T item;
        /**
         * 下一个节点
         */
        Node next;
    }
}
