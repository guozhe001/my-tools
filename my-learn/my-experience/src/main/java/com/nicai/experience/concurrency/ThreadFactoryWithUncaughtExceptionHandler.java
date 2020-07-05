package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * 带有未捕获异常处理器的线程工厂
 *
 * @author guozhe
 */
@Slf4j
public class ThreadFactoryWithUncaughtExceptionHandler implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        log.info("{}, creating new thread", this);
        Thread thread = new Thread(r);
        log.info("created {}", thread);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        log.info("eh={}", thread.getUncaughtExceptionHandler());
        return thread;
    }
}