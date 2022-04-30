package com.nicai.experience.concurrency;

import com.nicai.experience.fibonacci.Fibonacci;
import com.nicai.experience.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class LiftOffTest {

    /**
     * 直接运行run方法
     */
    @Test
    public void run() {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }

    /**
     * 创建新的线程运行
     */
    @Test
    public void runWithNewThread() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        log.info("wait for thread");
    }

    @Test
    public void printFibonacci() {
        for (int i = 0; i < 5; i++) {
            new Thread(fibonacciRunnable()).start();
        }
    }

    private Runnable fibonacciRunnable() {
        return () -> {
            Fibonacci fibonacci = new Fibonacci();
            for (int j = 0; j < 18; j++) {
                log.info("fibonacci={}", fibonacci.next());
            }
        };
    }

    /**
     * 使用线程池运行
     */
    @Test
    public void testCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }

    /**
     * 使用线程池运行，如果提交的任务特别多会导致内存消耗完而无法创新更多线程
     */
//    @Test(expected = OutOfMemoryError.class)
    public void testCachedThreadPoolMoreThread() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50000; i++) {
            executorService.execute(new LiftOff());
        }
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }

    /**
     * 使用固定个数线程的线程池运行
     */
    @Test
    public void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }

    /**
     * 使用单个线程的线程池运行
     */
    @Test
    public void testSingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        ThreadPoolUtil.waitAllThreadDone(executorService);
    }
}