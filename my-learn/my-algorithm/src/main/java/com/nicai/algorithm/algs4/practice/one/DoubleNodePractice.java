package com.nicai.algorithm.algs4.practice.one;

import java.util.Objects;

/**
 * DoubleNodePractice
 * 1.3.31　实现一个嵌套类DoubleNode用来构造双向链表，
 * 其中每个结点都含有一个指向前驱元素的引用和一项指向后续元素的引用（如果不存在则为null）。
 * 为以下任务实现若干静态方法：
 * 在表头插入结点
 * 在表尾插入结点
 * 从表头删除结点
 * 从表尾删除结点
 * 在指定结点之前插入新结点
 * 在指定结点之后插入新结点
 * 删除指定结点
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class DoubleNodePractice<T> {

    /**
     * 第一个节点
     */
    private DoubleNode<T> first;
    /**
     * 最后一个节点
     */
    private DoubleNode<T> end;

    /**
     * 在表头插入结点
     *
     * @param item 节点元素的值
     */
    public void addHead(T item) {
        DoubleNode<T> doubleNode = new DoubleNode<>();
        doubleNode.item = item;
        // 如果第一个节点为null，说明整个链表为空
        if (Objects.isNull(first)) {
            end = doubleNode;
        } else {
            first.prefix = doubleNode;
            doubleNode.next = first;
        }
        first = doubleNode;
    }

    /**
     * 在表尾插入结点
     *
     * @param item 节点元素的值
     */
    public void addTail(T item) {
        DoubleNode<T> doubleNode = new DoubleNode<>();
        doubleNode.item = item;
        // 如果链表的结尾为null，说明整个链表为空
        if (Objects.isNull(end)) {
            first = doubleNode;
        } else {
            end.next = doubleNode;
            doubleNode.prefix = end;
        }
        end = doubleNode;
    }

    /**
     * 从表头删除结点
     */
    public void deleteHead() {
        if (Objects.nonNull(first)) {
            if (Objects.nonNull(first.next)) {
                first.next.prefix = null;
            }
            // 如果只有一个节点
            if (first == end) {
                end = null;
            }
            first = first.next;
        }
    }

    /**
     * 从表尾删除结点
     */
    public void deleteTail() {
        if (Objects.nonNull(end)) {
            if (Objects.nonNull(end.prefix)) {
                end.prefix.next = null;
            }
            // 如果只有一个节点
            if (first == end) {
                first = null;
            }
            end = end.prefix;
        }
    }

    /**
     * 在指定结点之前插入新结点
     *
     * @param node 指定的节点
     * @param item 插入的新节点的值
     */
    public void addBefore(DoubleNode<T> node, T item) {
        DoubleNode<T> doubleNode = new DoubleNode<>();
        doubleNode.item = item;
        doubleNode.prefix = node.prefix;
        node.prefix = doubleNode;
        doubleNode.next = node;
    }

    /**
     * 在指定结点之后插入新结点
     *
     * @param node 指定的节点
     * @param item 插入的新节点的值
     */
    public void addAfter(DoubleNode<T> node, T item) {
        DoubleNode<T> doubleNode = new DoubleNode<>();
        doubleNode.item = item;
        doubleNode.next = node.next;
        doubleNode.prefix = node;
        node.next = doubleNode;
    }

    /**
     * 删除指定结点
     *
     * @param node 待删除的节点
     */
    public void delete(DoubleNode<T> node) {
        if (Objects.nonNull(node.prefix)) {
            node.prefix.next = node.next;
        }
        if (Objects.nonNull(node.next)) {
            node.next.prefix = node.prefix;
        }
        if (node == first) {
            first = node.next;
        }
        if (node == end) {
            end = node.prefix;
        }
    }

    private class DoubleNode<T> {
        /**
         * 当前元素的值
         */
        T item;
        /**
         * 前一个元素
         */
        DoubleNode<T> prefix;
        /**
         * 下一个元素
         */
        DoubleNode<T> next;

    }

}
