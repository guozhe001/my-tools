package com.nicai.algorithm.algs4.practice.one;

import java.util.Objects;

/**
 * GeneralizedQueueLinkedListImpl
 *
 * @author guozhe
 * @date 2020/10/14
 */
public class GeneralizedQueueLinkedListImpl<T> implements GeneralizedQueue<T> {

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

    public GeneralizedQueueLinkedListImpl() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T x) {
        ListNode<T> newEnd = new ListNode<>();
        newEnd.item = x;
        if (Objects.nonNull(end)) {
            end.next = newEnd;
        } else {
            first = newEnd;
        }
        size++;
        end = newEnd;
    }

    @Override
    public T delete(int k) {
        if (1 == k) {
            T item = first.item;
            if (first == end) {
                end = null;
            }
            first = first.next;
            size--;
            return item;
        }
        // 第几个元素
        int i = 1;
        ListNode<T> temp = first;
        while (i < k && Objects.nonNull(temp.next)) {
            i++;
            if (i == k) {
                T item = temp.next.item;
                temp.next = temp.next.next;
                size--;
                return item;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    private class ListNode<T> {
        T item;
        ListNode<T> next;
    }
}
