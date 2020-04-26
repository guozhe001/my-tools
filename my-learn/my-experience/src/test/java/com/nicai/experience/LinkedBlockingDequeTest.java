package com.nicai.experience;

import lombok.extern.slf4j.Slf4j;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2019-10-11
 */
@Slf4j
@RunWith(JMockit.class)
public class LinkedBlockingDequeTest {

    // 为什么这么写不执行呢？？？
    // TODO: 2019-10-11
//    private ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
//        @Override
//        public Thread newThread(Runnable r) {
//            return new Thread("my-learn");
//        }
//    });
    private ExecutorService putExecutorService = Executors.newFixedThreadPool(2);
    private ExecutorService takeExecutorService = Executors.newFixedThreadPool(10);

    @Test
    public void testAdd() throws InterruptedException {
        // 初始化一个队列大小为10的队列
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(10);
        // size方法是获取当前的队列里面有多少条数据，而不是总大小
        log.info("BlockingDeque default size is:={}", blockingDeque.size());

        // 多个线程take
        IntStream.range(0, 10).forEach(i -> takeExecutorService.submit(() -> {
            log.info("start take value");
            while (true) {
                try {
                    String value = blockingDeque.take();
                    log.info("take value success, value is {}", value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        // 多个线程去put
        IntStream.range(0, 100).parallel().forEach(i -> putExecutorService.submit(() -> {
            try {
                Thread.sleep(1L);
                blockingDeque.put(String.valueOf(i));
                log.info("put value i = {}", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        waitAllThreadDone(putExecutorService);
        takeExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
    }

    private void waitAllThreadDone(ExecutorService executorService) {
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
    }

}
