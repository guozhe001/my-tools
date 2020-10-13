package com.nicai.algorithm.algs4.practice.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * DoubleNodePracticeTest
 *
 * @author guozhe
 * @date 2020/10/13
 */
public class DoubleNodePracticeTest {

    @Test
    public void addHead() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addHead("b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        for (String s : new String[]{"b", "a"}) {
            Assert.assertEquals(s, doubleNodePractice.get());
        }
    }

    @Test
    public void addTail() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addTail("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addTail("b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        for (String s : new String[]{"a", "b"}) {
            Assert.assertEquals(s, doubleNodePractice.get());
        }
    }

    @Test
    public void deleteHead() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addTail("b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        doubleNodePractice.deleteHead();
        Assert.assertEquals(1, doubleNodePractice.size());
        Assert.assertEquals("b", doubleNodePractice.get());
    }

    @Test
    public void deleteTail() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addTail("b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        doubleNodePractice.deleteTail();
        Assert.assertEquals(1, doubleNodePractice.size());
        Assert.assertEquals("a", doubleNodePractice.get());
    }

    @Test
    public void addBefore() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addBefore(doubleNodePractice.getEnd(), "b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        Assert.assertEquals("b", doubleNodePractice.get());
    }

    @Test
    public void addAfter() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addAfter(doubleNodePractice.getEnd(), "b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        Assert.assertEquals("a", doubleNodePractice.get());
        Assert.assertEquals("b", doubleNodePractice.get());
    }

    @Test
    public void delete() {
        DoubleNodePractice<String> doubleNodePractice = new DoubleNodePractice<>();
        Assert.assertTrue(doubleNodePractice.isEmpty());
        doubleNodePractice.addHead("a");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        doubleNodePractice.addHead("b");
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(2, doubleNodePractice.size());
        doubleNodePractice.delete(doubleNodePractice.getFirst());
        Assert.assertFalse(doubleNodePractice.isEmpty());
        Assert.assertEquals(1, doubleNodePractice.size());
        Assert.assertEquals("a", doubleNodePractice.get());
    }
}