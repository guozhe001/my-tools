package com.nicai.algorithm.algs4.practice.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * GeneralizedQueueTest
 *
 * @author guozhe
 * @date 2020/10/14
 */
public class GeneralizedQueueTest {

    @Test
    public void testGeneralizedQueueArrayImpl() {
        test(new GeneralizedQueueArrayImpl<>());
    }

    @Test
    public void testGeneralizedQueueLinkedListImpl() {
        test(new GeneralizedQueueLinkedListImpl<>());
    }

    private void test(GeneralizedQueue<String> emptyQueue) {
        Assert.assertTrue(emptyQueue.isEmpty());
        for (String s : new String[]{"a", "b", "c", "d"}) {
            emptyQueue.insert(s);
        }
        Assert.assertFalse(emptyQueue.isEmpty());
        Assert.assertEquals("a", emptyQueue.delete(1));
        Assert.assertEquals("c", emptyQueue.delete(2));
        Assert.assertEquals("d", emptyQueue.delete(2));
        Assert.assertEquals("b", emptyQueue.delete(1));
        Assert.assertTrue(emptyQueue.isEmpty());
    }

}