package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P232ImplementQueueUsingStacksTest
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class P232ImplementQueueUsingStacksTest {

    @Test
    public void test1() {
        P232ImplementQueueUsingStacks.MyQueue myQueue = new P232ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assert.assertEquals(1, myQueue.peek());
        Assert.assertEquals(1, myQueue.pop());
        Assert.assertFalse(myQueue.empty());
    }

}