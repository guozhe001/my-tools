package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程练习
 * 守护线程并不属于程序中不可或缺的一部分，所以在所有的非守护线程结束时，程序就会终止；守护线程都会被杀掉。
 * 守护线程创建的任何线程都默认是守护线程
 */
@Slf4j
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                log.info("{} {}", Thread.currentThread(), this);
            }
        } catch (InterruptedException e) {
            log.error("sleep is Interrupted,{}", this, e);
        }
    }
}
