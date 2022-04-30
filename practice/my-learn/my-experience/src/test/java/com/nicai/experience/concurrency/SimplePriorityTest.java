package com.nicai.experience.concurrency;

import com.nicai.experience.util.ThreadPoolUtil;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorityTest {

    /**
     * 使用mac操作系统版本为10.15.4 (19E287)
     * 测试线程优先级不生效
     */
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