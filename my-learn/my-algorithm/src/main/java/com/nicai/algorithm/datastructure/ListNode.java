package com.nicai.algorithm.datastructure;

import lombok.Data;

/**
 * 链表的节点
 *
 * @author guozhe
 */
@Data
public class ListNode {
    /**
     * 当前的值
     */
    int val;
    /**
     * 下一个值
     */
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}