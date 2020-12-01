package com.nicai.experience.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * ExecutorService接口中的方法练习
 *
 * @author nicai
 * @date 2020/11/26
 */
@Slf4j
public class ExecutorServicePractice {

    static final String SUCCESS = "success";

    /**
     * practice:
     * Future<?> submit(Runnable task);
     */
    public Object submitWithRunnable() throws ExecutionException, InterruptedException {
        Future<?> submit = getExecutorService().submit(() -> log.info("hello, i'm submit method with Runnable param"));
        log.info("submit method with Runnable param,result={}", submit.get());
        return submit.get();
    }

    /**
     * practice:
     * <T> Future<T> submit(Callable<T> task);
     */
    public String submitWithCallable() throws ExecutionException, InterruptedException {
        Future<String> submit = getExecutorService().submit(
                () -> {
                    log.info("hello, i'm submit method with Callable param");
                    return SUCCESS;
                });
        log.info("submit method with Callable param,result={}", submit.get());
        return submit.get();
    }

    /**
     * practice:
     * <T> Future<T> submit(Runnable task, T result);
     */
    public String submitWithRunnableAndResult() throws ExecutionException, InterruptedException {
        Future<String> submit = getExecutorService().submit(
                () -> log.info("hello, i'm submit method with Runnable and Result param"), SUCCESS);
        log.info("submit method with Runnable and Result param,result={}", submit.get());
        return submit.get();
    }


    /**
     * practice:
     * void shutdown();
     * 执行结果：虽然shutdown了，并且线程池isShutdown()方法返回的也是true，但是正在执行的任务依然执行;正在等待的任务也会执行
     */
    public void shutdown() {
        ExecutorService executorService = getExecutorService();
        executorService.submit(this::logSomeNum);
        executorService.submit(this::logSomeNum);
        executorService.shutdown();
        boolean shutdown = executorService.isShutdown();
        log.info("shutdown result={}", shutdown);
    }


    /**
     * practice:
     * void shutdown();
     * 执行结果：在执行shutdown()方法之后，不能再添加任务
     */
    public void submitTaskAfterShutdown() {
        ExecutorService executorService = getExecutorService();
        executorService.submit(this::logSomeNum);
        executorService.shutdown();
        executorService.submit(this::logSomeNum);
        boolean shutdown = executorService.isShutdown();
        log.info("shutdown result={}", shutdown);
    }

    /**
     * practice:
     * void shutdown();
     * 执行结果：虽然shutdownNow()了，并且线程池isShutdown()方法返回的也是true，但是正在执行的任务依然执行;正在等待的任务不再执行
     */
    public void shutdownNow() {
        ExecutorService executorService = getExecutorService();
        executorService.submit(this::logSomeNum);
        executorService.submit(this::logSomeNum);
        executorService.shutdownNow();
        boolean shutdown = executorService.isShutdown();
        log.info("shutdown result={}", shutdown);
    }

    private void logSomeNum() {
        for (int i = 0; i < 1000; i++) {
            log.info("{}", i);
        }
    }

    private ExecutorService getExecutorService() {
        return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), new ThreadFactoryBuilder().setNameFormat("executorServicePractice-%d").build());
    }
}
