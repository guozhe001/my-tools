package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P19RemoveNthNodeFromEndOfListTest {

    P19RemoveNthNodeFromEndOfList.Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();

    /**
     * // 示例 1：
     * //
     * //
     * //输入：head = [1,2,3,4,5], n = 2
     * //输出：[1,2,3,5]
     */
    @Test
    void removeNthFromEnd() {
        P19RemoveNthNodeFromEndOfList.ListNode head = new P19RemoveNthNodeFromEndOfList.ListNode(1);
        head.next = new P19RemoveNthNodeFromEndOfList.ListNode(2);
        head.next.next = new P19RemoveNthNodeFromEndOfList.ListNode(3);
        head.next.next.next = new P19RemoveNthNodeFromEndOfList.ListNode(4);
        head.next.next.next.next = new P19RemoveNthNodeFromEndOfList.ListNode(5);
        invokeAndAssert(head, 2, new P19RemoveNthNodeFromEndOfList.ListNode(1));
    }

    private void invokeAndAssert(P19RemoveNthNodeFromEndOfList.ListNode head, int n, P19RemoveNthNodeFromEndOfList.ListNode expected) {
        P19RemoveNthNodeFromEndOfList.ListNode actual = solution.removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

}

