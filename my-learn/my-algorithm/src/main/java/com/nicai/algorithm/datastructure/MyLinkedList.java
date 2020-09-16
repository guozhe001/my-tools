package com.nicai.algorithm.datastructure;

import cn.hutool.core.lang.Assert;
import lombok.Data;

import java.util.Objects;

/**
 * 我的链表实现
 *
 * @author guozhe
 * @date 2020/09/14
 */
public class MyLinkedList<T> {

    /**
     * 第一个节点
     */
    private MyNode<T> first;

    /**
     * 最后一个节点
     */
    private MyNode<T> end;

    /**
     * 添加元素
     *
     * @param t 待添加的元素
     */
    void add(T t) {
        MyNode<T> myNode = new MyNode<>(t);
        // 如果最后一个节点为null，说明第一个节点也是null
        if (Objects.isNull(end)) {
            this.first = myNode;
        } else {
            end.next = myNode;
        }
        this.end = myNode;
    }

    /**
     * 删除一个元素
     *
     * @param t 待删除的元素
     */
    void remove(T t) {
        // 如果第一个元素为null，则说明此链表为空，不能删除
        Assert.notNull(this.first, "链表为空，无法删除");
        MyNode<T> temp = this.first;
        MyNode<T> parent = null;
        while (Objects.nonNull(temp)) {
            if (Objects.equals(t, temp)) {
                if (Objects.nonNull(parent)) {
                    parent.next = temp.next;
                    // 如果被删除的是第一个元素，则重新设置第一个元素
                    if (Objects.equals(this.first, t)) {
                        this.first = this.first.next;
                    }
                    if (Objects.equals(this.end, t)) {
                        this.end = parent;
                    }
                    break;
                }
            } else {
                parent = temp;
                temp = temp.next;
            }
        }
    }

    /**
     * 在target后面添加一个元素
     * 此操作也算是更新操作，因为更新了某个位置的元素
     *
     * @param t      待添加的元素
     * @param target 待添加的位置
     */
    void addAfter(T t, T target) {

    }

    /**
     * 节点
     *
     * @param <T> 节点数据的类型
     */
    @Data
    public static class MyNode<T> {
        public MyNode(T data) {
            this.data = data;
        }

        /**
         * 当前节点的数据
         */
        T data;
        /**
         * 下一个节点
         */
        MyNode<T> next;

    }


}
