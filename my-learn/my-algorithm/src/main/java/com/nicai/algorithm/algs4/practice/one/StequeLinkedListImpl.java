package com.nicai.algorithm.algs4.practice.one;

import java.util.Objects;

/**
 * 1.3.32 Steque。一个以栈为目标的队列（或称steque），是一种支持push、pop和enqueue操作的数据类型。为这种抽象数据类型定义一份API并给出一份基于链表的实现。
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class StequeLinkedListImpl<T> implements Steque<T> {
    /**
     * 第一个节点
     */
    private ListNode<T> first;
    /**
     * 最后一个节点
     */
    private ListNode<T> end;
    /**
     * 当前队列的大小
     */
    private int size;

    public StequeLinkedListImpl() {
        this.size = 0;
    }

    @Override
    public void push(T item) {
        ListNode<T> node = new ListNode<>();
        node.item = item;
        // 把元素压入开头
        if (Objects.nonNull(end)) {
            node.next = first;
            first = node;
        } else {
            first = node;
            end = node;
        }
        size++;
    }

    @Override
    public T pop() {
        if (Objects.nonNull(first)) {
            T item = first.item;
            first = first.next;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public void enqueue(T item) {
        ListNode<T> node = new ListNode<>();
        node.item = item;
        if (Objects.isNull(end)) {
            first = node;
        } else {
            end.next = node;
        }
        end = node;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class ListNode<T> {
        T item;
        ListNode<T> next;
    }


}
