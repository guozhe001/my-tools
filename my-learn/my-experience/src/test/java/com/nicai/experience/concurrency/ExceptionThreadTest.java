package com.nicai.experience.concurrency;

import com.google.common.util.concurrent.*;
import com.nicai.experience.exception.NicaiException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExceptionThreadTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void run() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(this::runWithException);
        TimeUnit.MILLISECONDS.sleep(100L);
        Assert.assertFalse(systemOutRule.getLog().contains("出错啦！"));
    }

    @Test
    public void runWithUncaughtExceptionHandler() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(
                new ThreadFactoryBuilder()
                        .setUncaughtExceptionHandler((t, e) -> log.info("UncaughtExceptionHandler caught, error_message={}", e.getMessage(), e))
                        .build());
        executorService.execute(this::runWithException);
        TimeUnit.MILLISECONDS.sleep(100L);
        Assert.assertTrue(systemOutRule.getLog().contains("出错啦！"));
    }

    @Test
    public void runWithGuavaThreadPool() throws InterruptedException {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        ListenableFuture<String> listenableFuture = executorService.submit(this::runWithException);
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info("success! result = {}", result);
            }

            @Override
            public void onFailure(Throwable t) {
                log.error("guava FutureCallback caught, error_message={}", t.getMessage(), t);
            }
        }, executorService);
        TimeUnit.MILLISECONDS.sleep(100L);
        Assert.assertTrue(systemOutRule.getLog().contains("出错啦！"));
    }

    private String runWithException() {
        Thread thread = Thread.currentThread();
        log.info("thread is {}", thread);
        log.info("eh={}", thread.getUncaughtExceptionHandler());
        throw new NicaiException("出错啦！");
    }

    @Before
    public void cleanLog() {
        systemOutRule.clearLog();
    }

}