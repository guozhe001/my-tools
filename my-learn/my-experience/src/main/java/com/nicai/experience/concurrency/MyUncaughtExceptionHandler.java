package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * 未捕获的异常处理器
 *
 * @author guozhe
 */
@Slf4j
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.info("caught ", e);
    }

}