package com.nicai.algorithm.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.Stack;

/**
 * @author guozhe
 * @date 2020-05-11
 */
@Slf4j
public class P2AddTwoNumbersTest {

    private static final P2AddTwoNumbers.Solution solution = new P2AddTwoNumbers().new Solution();

    @Test
    public void getNumber() {
        long number = solution.listNodeToNum(getListNode("2, 4, 3"));
        Assert.assertEquals(342L, number);
    }

    @Test
    public void getNumber0() {
        long number = solution.listNodeToNum(getListNode("5, 6, 4"));
        Assert.assertEquals(465L, number);
    }

    @Test
    public void numberToListNode() {
        P2AddTwoNumbers.ListNode listNode = solution.numberToListNode(807);
        printListNode(listNode, new int[]{7, 0, 8});
    }

    @Test
    public void addTwoNumbers() {
        P2AddTwoNumbers.ListNode listNode = solution.addTwoNumbers(getListNode("2,4,3"), getListNode("5,6,4"));
        printListNode(listNode, new int[]{7, 0, 8});
    }

    @Test
    public void addTwoNumbers0() {
        P2AddTwoNumbers.ListNode listNode = solution.addTwoNumbers(getListNode("5"), getListNode("5"));
        printListNode(listNode, new int[]{0, 1});
    }

    @Test
    public void addTwoNumbers1() {
        P2AddTwoNumbers.ListNode listNode = solution.addTwoNumbers(solution.numberToListNode(9), getListNode("1,9,9,9,9,9,9,9,9,9"));
        printListNode(listNode, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
    }

    @Test
    public void addTwoNumbers2() {
        String[] split = split("1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1");
        P2AddTwoNumbers.ListNode l2 = getListNode(split, 0);
        P2AddTwoNumbers.ListNode l1 = getListNode(split("5,6,4"), 0);
        P2AddTwoNumbers.ListNode result = solution.addTwoNumbers(l1, l2);
        printListNode(result, toIntArray(split("6, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1")));
    }

    @Test
    public void addTwoNumbers3() {
        String[] split = split("9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1");
        P2AddTwoNumbers.ListNode l2 = getListNode(split, 0);
        P2AddTwoNumbers.ListNode l1 = getListNode(split("5,6,4"), 0);
        P2AddTwoNumbers.ListNode result = solution.addTwoNumbers(l1, l2);
        printListNode(result, toIntArray(split("4, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1")));
    }


    String[] split(String string) {
        return string.split(",");
    }

    private void printListNode(P2AddTwoNumbers.ListNode listNode, int[] expect) {
        for (int value : expect) {
            log.info("{}", listNode.val);
            Assert.assertEquals(value, listNode.val);
            listNode = listNode.next;
        }
    }

    P2AddTwoNumbers.ListNode getListNode(String[] strings, int startIndex) {
        P2AddTwoNumbers.ListNode result = null;
        if (startIndex < strings.length) {
            result = new P2AddTwoNumbers().new ListNode(Integer.valueOf(strings[startIndex].trim()));
            result.next = getListNode(strings, startIndex + 1);
        }
        return result;
    }

    P2AddTwoNumbers.ListNode getListNode(String string) {
        return getListNode(split(string), 0);
    }

    private int[] toIntArray(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.valueOf(strings[i].trim());
        }
        return ints;
    }

    /**
     * private int getValue(ListNode l1)
     */
    @Test
    public void getValue() throws Exception {
        Stack<Integer> stack = Whitebox.invokeMethod(solution, "nodeToStack", getListNode("2, 4, 3"));
        Integer[] expect = new Integer[]{2, 4, 3};
        for (Integer i : expect) {
            Assert.assertEquals(i, stack.pop());
        }
    }

    /**
     * private int getValue(ListNode l1)
     */
    @Test
    public void getValue1() throws Exception {
        Stack<Integer> stack = Whitebox.invokeMethod(solution, "nodeToStack", getListNode("5, 6, 4"));
        Integer[] expect = new Integer[]{5, 6, 4};
        for (Integer i : expect) {
            Assert.assertEquals(i, stack.pop());
        }
    }

    /**
     * private int getValue(ListNode l1)
     */
    @Test
    public void stackToNode() throws Exception {
        P2AddTwoNumbers.ListNode root = Whitebox.invokeMethod(solution, "stackToNode", getStack(new int[]{7, 0, 8}));
        int[] expect = {7, 0, 8};
        for (int i : expect) {
            Assert.assertEquals(i, root.val);
            root = root.next;
        }
    }

    private Stack<Integer> getStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            stack.push(i);
        }
        return stack;
    }

}