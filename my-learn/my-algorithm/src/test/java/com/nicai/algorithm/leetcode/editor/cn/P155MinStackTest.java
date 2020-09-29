package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P155MinStackTest
 *
 * @author guozhe
 * @date 2020/09/29
 */
public class P155MinStackTest {

    @Test
    public void test() {
        P155MinStack.MinStack obj = new P155MinStack().new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        Assert.assertEquals(-3, obj.getMin());
        obj.pop();
        Assert.assertEquals(0, obj.top());
        Assert.assertEquals(-2, obj.getMin());
    }

}