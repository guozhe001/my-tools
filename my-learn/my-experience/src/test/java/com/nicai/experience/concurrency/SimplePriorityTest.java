package com.nicai.experience.concurrency;

import com.nicai.experience.util.ThreadPoolUtil;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorityTest {

    @Test
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }

}