package com.nicai.experience.concurrency;

import com.nicai.experience.util.ThreadPoolUtil;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOffWithSleepTest {

    @Test
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOffWithSleep());
        }
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }
}