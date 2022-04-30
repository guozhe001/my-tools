package com.nicai.algorithm.book.algs4.practice.one;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 链表练习
 *
 * @author guozhe
 * @date 2020/10/12
 */
@Slf4j
public class ListNodePractice {

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

    /**
     * 1.3.21　编写一个方法find()，接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域的值为key，则方法返回true，否则返回false。
     *
     * @param first 链表的起始节点
     * @param key   待查找的节点的值
     */
    public boolean find(ListNode<String> first, String key) {
        while (Objects.nonNull(first)) {
            if (Objects.equals(first.item, key)) {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    /**
     * 1.3.24　编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参数结点或参数结点的后续结点为空则什么也不做）。
     */
    public void removeAfter(ListNode<String> node) {
        if (Objects.nonNull(node)) {
            node.next = null;
        }
    }

    /**
     * 1.3.25　编写一个方法insertAfter()，接受两个链表结点作为参数，将第二个结点插入链表并使之成为第一个结点的后续结点（如果两个参数为空则什么也不做）。
     *
     * @param node1 节点1
     * @param node2 节点2
     */
    public void insertAfter(ListNode<String> node1, ListNode<String> node2) {
        if (Objects.nonNull(node1) && Objects.nonNull(node2)) {
            ListNode<String> next = node1.next;
            node1.next = node2;
            node2.next = next;
        }
    }

    /**
     * 1.3.26　编写一个方法remove()，接受一条链表和一个字符串key作为参数，删除链表中所有item域为key的结点。
     */
    public ListNode<String> remove(ListNode<String> node, String key) {
        ListNode<String> result = node;
        // 第一个元素，如果item是key，则删除第一个元素
        while (Objects.nonNull(result)) {
            if (Objects.equals(result.item, key)) {
                result = result.next;
            } else {
                break;
            }
        }
        while (Objects.nonNull(result) && Objects.nonNull(result.next)) {
            if (Objects.equals(result.next.item, key)) {
                result.next = result.next.next;
            } else {
                result = result.next;
            }
        }
        return result;
    }

    /**
     * 1.3.27　编写一个方法max()，接受一条链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。
     *
     * @param first 链表的起始节点
     * @return 返回链表中键最大的节点的值
     */
    public int max(ListNode<Integer> first) {
        int max = 0;
        while (Objects.nonNull(first)) {
            max = Math.max(first.item, max);
            first = first.next;
        }
        return max;
    }
    /**
     * 1.3.28　用递归的方法解答"编写一个方法max()，接受一条链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。"
     *
     * @param first 链表的起始节点
     * @return 返回链表中键最大的节点的值
     */
    public int maxRecursive(ListNode<Integer> first) {
        return Objects.isNull(first) ? 0 : Math.max(first.item, maxRecursive(first.next));
    }


}