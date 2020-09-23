package com.nicai.algorithm.nowcoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * ReverseListTest
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class ReverseListTest {

    /**
     * 待测的解决方案
     */
    private static final ReverseList.Solution SOLUTION = new ReverseList().new Solution();

    @Test
    public void ReverseList() {
        ReverseList.ListNode listNode = SOLUTION.reverse(getListNode(new int[]{1, 2, 3, 4, 5}, 0));
        int[] expect = new int[]{5, 4, 3, 2, 1};
        for (int i : expect) {
            Assert.assertEquals(i, listNode.val);
            listNode = listNode.next;
        }
    }

    ReverseList.ListNode getListNode(int[] nums, int startIndex) {
        ReverseList.ListNode result = null;
        if (startIndex < nums.length) {
            result = new ReverseList.ListNode(nums[startIndex]);
            result.next = getListNode(nums, startIndex + 1);
        }
        return result;
    }

}