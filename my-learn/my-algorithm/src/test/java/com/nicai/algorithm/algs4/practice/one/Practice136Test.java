package com.nicai.algorithm.algs4.practice.one;

import com.nicai.algorithm.datastructure.Queue;
import com.nicai.algorithm.datastructure.impl.QueueImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Practice136Test
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice136Test {

    @Test
    public void reverse() {
        Practice136 practice136 = new Practice136();
        Queue<String> q = getQueue("a", "b", "c", "d");
        practice136.reverse(q);
        for (String s : new String[]{"d", "c", "b", "a"}) {
            Assert.assertEquals(s, q.dequeue());
        }
    }

    private Queue<String> getQueue(String item, String... items) {
        Queue<String> q = new QueueImpl<>();
        q.enqueue(item);
        for (String s : items) {
            q.enqueue(s);
        }
        return q;
    }
}