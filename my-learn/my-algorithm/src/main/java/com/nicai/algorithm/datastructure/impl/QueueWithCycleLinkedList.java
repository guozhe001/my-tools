package com.nicai.algorithm.datastructure.impl;

import com.nicai.algorithm.datastructure.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 用环形链表实现Queue
 * 1.3.29　用环形链表实现Queue。
 * 环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非空则last.next的值为first。
 * 只能使用一个Node类型的实例变量（last）。
 *
 * @author guozhe
 * @date 2020/10/12
 */
public class QueueWithCycleLinkedList<T> implements Queue<T> {

    /**
     * 最后一个节点
     */
    ListNode<T> last;
    /**
     * 队列的长度
     */
    int size;

    @Override
    public void enqueue(T item) {
        ListNode<T> newLast = new ListNode<>();
        newLast.item = item;
        if (Objects.nonNull(last)) {
            newLast.next = last.next;
            last.next = newLast;
        } else {
            newLast.next = newLast;
        }
        last = newLast;
        size++;
    }

    @Override
    public T dequeue() {
        if (Objects.nonNull(last)) {
            T result = last.next.item;
            if (last == last.next) {
                last = null;
            } else {
                last.next = last.next.next;
            }
            size--;
            return result;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(last);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new CycleLinkedListIterator();
    }

    private class CycleLinkedListIterator implements Iterator<T> {
        int i = 0;
        ListNode<T> tempLast = last;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            if (i <= size) {
                T item = tempLast.next.item;
                if (i == size) {
                    tempLast = null;
                } else {
                    tempLast = tempLast.next;
                }
                i++;
                return item;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    private class ListNode<T> {
        T item;
        ListNode<T> next;
    }
}
