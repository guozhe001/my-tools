package com.nicai.algorithm.book.algs4.practice.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * DequeTest
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class DequeTest {

    @Test
    public void testPopLeft() {
        Deque<String> deque = init();
        for (String s : new String[]{"a", "b", "c", "d"}) {
            Assert.assertEquals(s, deque.popLeft());
        }
    }

    @Test
    public void testPopRight() {
        Deque<String> deque = init();
        for (String s : new String[]{"d", "c", "b", "a"}) {
            Assert.assertEquals(s, deque.popRight());
        }

    }

    private Deque<String> init() {
        Deque<String> deque = new Deque<>();
        Assert.assertTrue(deque.isEmpty());
        boolean left = true;
        for (String s : new String[]{"b", "c", "a", "d"}) {
            if (left) {
                deque.pushLeft(s);
            } else {
                deque.pushRight(s);
            }
            left = !left;
        }
        Assert.assertFalse(deque.isEmpty());
        Assert.assertEquals(4, deque.size());
        return deque;
    }


}