package com.nicai.algorithm.datastructure.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * 链表测试
 *
 * @author guozhe
 * @date 2020/10/12
 */
@Slf4j
public class ListNodeTest {

    @Test
    public void deleteEndNode() {
        ListNode<String> first = getListNode();
        deleteEndNode(first);
        ListNode<String> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)) {
            log.info(temp.item);
            temp = temp.next;
            i++;
        }
        Assert.assertEquals(3, i);
    }

    /**
     * 1.3.19　给出一段代码，删除链表的尾结点，其中链表的首结点为first。
     *
     * @param first 链表的起始节点
     */
    public void deleteEndNode(ListNode<String> first) {
        while (Objects.nonNull(first) && Objects.nonNull(first.next)) {
            if (Objects.isNull(first.next.next)) {
                first.next = null;
            } else {
                first = first.next;
            }
        }
    }

    private ListNode<String> getListNode() {
        ListNode<String> first = new ListNode<>();
        first.item = "a";
        ListNode<String> end = first;
        for (String s : new String[]{"b", "c", "d"}) {
            ListNode<String> newEnd = new ListNode<>();
            newEnd.item = s;
            end.next = newEnd;
            end = newEnd;
        }
        return first;
    }

    @Test
    public void deleteNodeK() {
        ListNode<String> first = getListNode();
        deleteNodeK(first, 2);
        ListNode<String> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)) {
            String item = temp.item;
            log.info(item);
            temp = temp.next;
            i++;
            if (i == 2) {
                Assert.assertEquals("c", item);
            }
        }
        Assert.assertEquals(3, i);
    }


    /**
     * 1.3.20　编写一个方法delete()，接受一个int参数k，删除链表的第k个元素（如果它存在的话）。
     *
     * @param first 链表的起始节点
     * @param k     第k个节点
     */
    public void deleteNodeK(ListNode<String> first, int k) {
        int index = 1;
        while (Objects.nonNull(first) && index < k) {
            // 如果此时是k元素的前面的元素
            if (index == k - 1 && Objects.nonNull(first.next)) {
                first.next = first.next.next;
                break;
            } else {
                first = first.next;
                index++;
            }
        }
    }

    private class ListNode<T> {
        T item;
        ListNode<T> next;
    }
}