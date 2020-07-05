package com.nicai.experience.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThreadTest {


    @Test
    public void runWithUncaughtExceptionHandler() {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithUncaughtExceptionHandler());
        executorService.execute(new ExceptionThread());
    }

    @Test
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }

}