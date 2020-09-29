package com.nicai.algorithm.leetcode.editor.cn;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 313 👎 0

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * 重排链表
 *
 * @author nicai
 */
public class P143ReorderList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (Objects.isNull(head)) {
                return;
            }
            LinkedList<ListNode> listNodes = new LinkedList<>();
            ListNode tempHead = head;
            // 遍历第一遍，把数据从链表放在队列
            while (Objects.nonNull(tempHead)) {
                listNodes.offer(tempHead);
                tempHead = tempHead.next;
            }
            tempHead = listNodes.removeFirst();
            head = tempHead;
            boolean fromStart = false;
            while (!listNodes.isEmpty()) {
                ListNode next = fromStart ? listNodes.removeFirst() : listNodes.removeLast();
                if (Objects.isNull(next)) {
                    // 如果是最后一个节点，则设置下个节点为null，防止编程循环链表
                    tempHead.next = null;
                    break;
                }
                tempHead.next = next;
                tempHead = tempHead.next;
                fromStart = !fromStart;
            }
        }

        public void reorderListQueueAndStack(ListNode head) {
            if (Objects.isNull(head)) {
                return;
            }
            Queue<ListNode> listNodeQueue = new LinkedList<>();
            Stack<ListNode> listNodeStack = new Stack<>();
            ListNode tempHead = head;
            // 遍历第一遍，把数据从链表放在队列
            while (Objects.nonNull(tempHead)) {
                listNodeQueue.offer(tempHead);
                listNodeStack.push(tempHead);
                tempHead = tempHead.next;
            }
            tempHead = listNodeQueue.poll();
            head = tempHead;
            boolean fromStack = true;
            while (!listNodeQueue.isEmpty()) {
                ListNode next = fromStack ? listNodeStack.pop() : listNodeQueue.poll();
                if (Objects.equals(tempHead, next)) {
                    // 如果是最后一个节点，则设置下个节点为null，防止编程循环链表
                    tempHead.next = null;
                    break;
                }
                tempHead.next = next;
                tempHead = tempHead.next;
                fromStack = !fromStack;
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}