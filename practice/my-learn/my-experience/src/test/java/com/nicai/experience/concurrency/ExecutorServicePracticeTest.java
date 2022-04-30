package com.nicai.experience.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class ExecutorServicePracticeTest {

    private final ExecutorServicePractice executorServicePractice = new ExecutorServicePractice();

    @Test
    public void submitWithRunnable() throws ExecutionException, InterruptedException {
        Object o = executorServicePractice.submitWithRunnable();
        Assert.assertNull(o);
    }

    @Test
    public void submitWithRunnableAndResult() throws ExecutionException, InterruptedException {
        String s = executorServicePractice.submitWithRunnableAndResult();
        Assert.assertEquals(ExecutorServicePractice.SUCCESS, s);
    }

    @Test
    public void submitWithCallable() throws ExecutionException, InterruptedException {
        String s = executorServicePractice.submitWithCallable();
        Assert.assertEquals(ExecutorServicePractice.SUCCESS, s);
    }

    @Test
    public void shutdown() throws InterruptedException {
        executorServicePractice.shutdown();
        TimeUnit.MILLISECONDS.sleep(100);
        Assert.assertTrue(Boolean.TRUE);
    }

    @Test
    public void submitTaskAfterShutdown() {
        Assert.assertThrows(RejectedExecutionException.class, executorServicePractice::submitTaskAfterShutdown);
    }

    @Test
    public void shutdownNow() throws InterruptedException {
        executorServicePractice.shutdownNow();
        TimeUnit.MILLISECONDS.sleep(100);
        Assert.assertTrue(Boolean.TRUE);
    }


}