package com.nicai.algorithm.datastructure;

import com.google.common.collect.Lists;
import com.nicai.algorithm.datastructure.impl.FixedCapacityQueue;
import com.nicai.algorithm.datastructure.impl.QueueImpl;
import com.nicai.algorithm.datastructure.impl.ResizingArrayQueue;
import edu.princeton.cs.algs4.StdOut;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * QueueTest
 *
 * @author guozhe
 * @date 2020/09/27
 */
@Slf4j
public class QueueTest {
    private static final String[] STRINGS = new String[]{"hello", "my", "first", "queue"};

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

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

    /**
     * practice 1.3.15
     * 1.3.15　编写一个Queue的用例，接受一个命令行参数k并打印出标准输入中的倒数第k个字符串（假设标准输入中至少有k个字符串）。
     */
    public void printK(String[] strings, int k) {
        cn.hutool.core.lang.Assert.isTrue(strings.length >= k);
        Queue<String> stringQueue = new QueueImpl<>();
        for (String s : strings) {
            stringQueue.enqueue(s);
        }
        String result = null;
        int resultIndex = stringQueue.size() - k;
        for (int i = 0; i <= resultIndex; i++) {
            result = stringQueue.dequeue();
        }
        StdOut.print(result);
    }

    @Test
    public void printKTest() {
        printK(new String[]{"a", "b", "c", "d", "e"}, 2);
        Assert.assertTrue(systemOutRule.getLog().contains("d"));
    }

}