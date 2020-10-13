package com.nicai.algorithm.algs4.practice.one;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 一个双向队列
 * 1.3.33Deque。一个双向队列（或者称为deque）和栈或队列类似，但它同时支持在两端添加或删除元素。
 * Deque能够存储一组元素并支持表1.3.9中的API：表1.3.9　泛型双向队列的API publicclassDeque<Item>implementsIterable<Item> 
 * Deque():创建空双向队列
 * boolean isEmpty():双向队列是否为空
 * intsize():双向队列中的元素数量
 * void pushLeft(Item item):向左端添加一个新元素
 * void pushRight(Item item):向右端添加一个新元素
 * Item popLeft():从左端删除一个元素
 * Item popRight():从右端删除一个元素
 * <p>
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class Deque<T> implements Iterable<T> {

    /**
     * 双向链表的第一个节点
     */
    private ListNode<T> first;
    /**
     * 双向链表的最后一个节点
     */
    private ListNode<T> end;

    /**
     * 队列的大小
     */
    private int size;

    public Deque() {
        this.size = 0;
    }

    /**
     * 双向队列是否为空
     *
     * @return 如果双向队列为空，则返回true，否则返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 双向队列中的元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 向左端添加一个新元素
     *
     * @param item 待添加的元素
     */
    void pushLeft(T item) {
        ListNode<T> node = new ListNode<>(item);
        if (isEmpty()) {
            end = node;
        } else {
            first.prefix = node;
            node.next = first;
        }
        first = node;
        size++;
    }

    /**
     * 向右端添加一个新元素
     *
     * @param item 待添加的元素
     */
    void pushRight(T item) {
        ListNode<T> node = new ListNode<>(item);
        if (isEmpty()) {
            first = node;
        } else {
            node.prefix = end;
            end.next = node;
        }
        end = node;
        size++;
    }

    /**
     * 从左端删除一个元素
     *
     * @return 最左端的元素
     */
    T popLeft() {
        if (!isEmpty()) {
            T item = first.item;
            // 如果有下一个节点，设置下一个节点的前一个节点为null
            if (Objects.nonNull(first.next)) {
                first.next.prefix = null;
            } else {
                end = null;
            }
            first = first.next;
            size--;
            return item;
        }
        return null;
    }

    /**
     * 从右端删除一个元素
     *
     * @return 最右端的元素
     */
    T popRight() {
        if (!isEmpty()) {
            T item = end.item;
            if (Objects.nonNull(end.prefix)) {
                end.prefix.next = null;
            } else {
                first = null;
            }
            end = end.prefix;
            size--;
            return item;
        }
        return null;
    }

    @Override

    public Iterator<T> iterator() {
        return new ListNodeIterator();
    }

    private class ListNodeIterator implements Iterator<T> {
        ListNode<T> tempNode = first;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(tempNode);
        }

        @Override
        public T next() {
            if (Objects.nonNull(tempNode)) {
                T item = tempNode.item;
                tempNode = tempNode.next;
                return item;
            } else {
                throw new NoSuchElementException();
            }

        }
    }

    private class ListNode<T> {
        T item;
        ListNode<T> prefix;
        ListNode<T> next;

        private ListNode(T item) {
            this.item = item;
        }
    }
}
