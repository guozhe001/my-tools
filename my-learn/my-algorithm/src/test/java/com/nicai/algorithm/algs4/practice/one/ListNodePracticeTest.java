package com.nicai.algorithm.algs4.practice.one;

import lombok.extern.slf4j.Slf4j;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * ListNodePracticeTest
 *
 * @author guozhe
 * @date 2020/10/12
 */
@Slf4j
public class ListNodePracticeTest {

    @Tested
    private ListNodePractice listNodePractice;

    @Test
    public void deleteEndNode() {
        ListNode<String> first = getListNode();
        listNodePractice.deleteEndNode(first);
        ListNode<String> temp = first;
        int i = 0;
        while (Objects.nonNull(temp)) {
            log.info(temp.item);
            temp = temp.next;
            i++;
        }
        Assert.assertEquals(3, i);
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
        listNodePractice.deleteNodeK(first, 2);
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


    @Test
    public void find() {
        Assert.assertTrue(listNodePractice.find(getListNode(), "c"));
    }

    @Test
    public void removeAfter() {
        ListNode<String> listNode = getListNode();
        listNodePractice.removeAfter(listNode.next);
        int i = 0;
        while (Objects.nonNull(listNode)) {
            log.info("{}", listNode.item);
            listNode = listNode.next;
            i++;
        }
        Assert.assertEquals(2, i);
    }

    @Test
    public void insertAfter() {
        ListNode<String> listNode = getListNode();
        ListNode<String> listNode2 = new ListNode<>();
        listNode2.item = "e";
        listNodePractice.insertAfter(listNode.next, listNode2);
        for (String s : new String[]{"a", "b", "e", "c", "d"}) {
            Assert.assertEquals(s, listNode.item);
            listNode = listNode.next;
        }
    }

    @Test
    public void remove() {
        ListNode<String> listNode = getListNode("c");
        listNode.next = getListNode();
        ListNode<String> newListNode = listNodePractice.remove(listNode, "c");
        while (Objects.nonNull(newListNode)) {
            Assert.assertNotEquals(newListNode.item, "c");
            newListNode = newListNode.next;
        }
    }

    @Test
    public void max() {
        ListNode<Integer> listNode = getListNode(new Integer[]{3, 1, 4, 5, 6, 2, 8, 9});
        Assert.assertEquals(9, listNodePractice.max(listNode));
    }

    @Test
    public void maxRecursive() {
        ListNode<Integer> listNode = getListNode(new Integer[]{3, 1, 4, 5, 6, 2, 8, 9});
        Assert.assertEquals(9, listNodePractice.maxRecursive(listNode));
    }

    private <T> ListNode<T> getListNode(T[] items) {
        ListNode<T> listNode = new ListNode<>();
        listNode.item = items[0];
        for (int i = 1; i < items.length; i++) {
            ListNode<T> newListNode = new ListNode<>();
            newListNode.next = listNode;
            newListNode.item = items[i];
            listNode = newListNode;
        }
        return listNode;
    }

    public ListNode<String> getListNode(String item) {
        ListNode<String> listNode = new ListNode<>();
        listNode.item = item;
        return listNode;
    }


}