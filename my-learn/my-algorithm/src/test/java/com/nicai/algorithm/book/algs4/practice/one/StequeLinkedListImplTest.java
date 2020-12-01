package com.nicai.algorithm.book.algs4.practice.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * StequeLinkedListImplTest
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class StequeLinkedListImplTest {

    @Test
    public void test() {
        Steque<String> steque = new StequeLinkedListImpl<>();
        Assert.assertEquals(0, steque.size());
        Assert.assertTrue(steque.isEmpty());
        steque.push("b");
        steque.push("c");
        steque.enqueue("a");
        Assert.assertEquals(3, steque.size());
        Assert.assertFalse(steque.isEmpty());
        for (String s : new String[]{"c", "b", "a"}) {
            Assert.assertEquals(s, steque.pop());
        }
    }

}