package com.nicai.algorithm.datastructure.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * FixedCapacityStackTest
 *
 * @author guozhe
 * @date 2020/09/28
 */
public class FixedCapacityStackTest {

    @Test
    public void isFull() {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
        for (int i = 0; i < 10; i++) {
            stack.push("item" + i);
        }
        Assert.assertTrue(stack.isFull());
    }

}