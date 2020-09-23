package com.nicai.algorithm.nowcoder;

/**
 * 反转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&&tqId=35464&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class ReverseList {
    public class Solution {
        public ListNode reverse(ListNode head) {
            ListNode result = null;
            for (ListNode node = head; node != null; node = node.next) {
                ListNode listNode = new ListNode(node.val);
                listNode.next = result;
                result = listNode;
            }
            return result;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
