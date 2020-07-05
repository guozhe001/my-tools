package com.nicai.experience.concurrency;

import com.nicai.experience.exception.NicaiException;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试线程抛出异常
 * 直接由线程抛出的异常，在调用此线程的地方使用try-catch是无法捕获异常的
 *
 * @author guozhe
 */
@Slf4j
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        log.info("thread is {}", thread);
        log.info("eh={}", thread.getUncaughtExceptionHandler());
        throw new NicaiException();
    }

}
