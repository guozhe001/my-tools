package com.nicai.experience.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonThreadFactoryTest {

    @Test
    public void newThread() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SimpleDaemons());
        }
        TimeUnit.MILLISECONDS.sleep(500);
    }
}