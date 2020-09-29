package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P143ReorderListTest
 *
 * @author guozhe
 * @date 2020/09/29
 */
public class P143ReorderListTest {

    private P143ReorderList.Solution solution = new P143ReorderList().new Solution();

    private static final P143ReorderList.ListNode listNode1 = new P143ReorderList().new ListNode(1);
    private static final P143ReorderList.ListNode listNode2 = new P143ReorderList().new ListNode(2);
    private static final P143ReorderList.ListNode listNode3 = new P143ReorderList().new ListNode(3);
    private static final P143ReorderList.ListNode listNode4 = new P143ReorderList().new ListNode(4);
    private static final P143ReorderList.ListNode listNode5 = new P143ReorderList().new ListNode(5);


    /**
     * 示例 1:
     * <p>
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     */
    @Test
    public void reorderList1() {
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        solution.reorderList(listNode1);
        assertResult(listNode1, new int[]{1, 4, 2, 3});
    }

    private void assertResult(P143ReorderList.ListNode listNode, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            Assert.assertEquals(ints[i], listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 示例 2:
     * <p>
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */

    @Test
    public void reorderList2() {
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        solution.reorderList(listNode1);
    }
}