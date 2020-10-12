package com.nicai.algorithm.datastructure;

import com.google.common.collect.Lists;
import com.nicai.algorithm.datastructure.impl.FixedCapacityQueue;
import com.nicai.algorithm.datastructure.impl.QueueImpl;
import com.nicai.algorithm.datastructure.impl.ResizingArrayQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * QueueTest
 *
 * @author guozhe
 * @date 2020/09/27
 */
@Slf4j
public class QueueTest {
    private static final String[] STRINGS = new String[]{"hello", "my", "first", "queue"};

    @Test
    public void queue() {
        Lists.newArrayList(new QueueImpl<String>(), new FixedCapacityQueue<String>(4), new ResizingArrayQueue<String>()).forEach(this::queue);
    }

    public void queue(Queue<String> queue) {
        for (String string : STRINGS) {
            queue.enqueue(string);
        }
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(STRINGS.length, queue.size());
        for (String str : queue) {
            log.info(str);
        }
        for (String string : STRINGS) {
            Assert.assertEquals(string, queue.dequeue());
        }
    }

}