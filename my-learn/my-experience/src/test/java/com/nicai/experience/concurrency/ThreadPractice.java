package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Random;

/**
 * 线程练习
 *
 * @author nicai
 * @date 2020/11/26
 */
@Slf4j
public class ThreadPractice {

    /**
     * 是否执行成功
     */
    private Boolean success = null;

    public static void main(String[] args) {
        final ThreadPractice threadPractice = new ThreadPractice();
        /*
         * 实现这样一个场景：
         * 有两个线程，同时执行不同的工作，但是其中一个线程在执行的过程中依赖另一个线程执行的结果；如何实现？
         */
        new Thread(threadPractice::task1).start();
        new Thread(threadPractice::task2).start();
    }

    /**
     * 任务1，在执行的过程中等待任务2的执行结果
     */
    private void task1() {
        log.info("task1 exe start...");
        // 自己的事情做完之后，等待task2的执行结果
        while (Objects.isNull(success)) {
            log.info("task1 wait task2 result...");
        }
        log.info("i'm task1, task2's result is {}", success);
        log.info("task1 exe end...");
    }

    /**
     * 任务2，执行完成之后修改状态
     * 如果任务执行成功，修改状态为true；否哦则修改状态为false
     */
    private void task2() {
        Random random = new Random();
        log.info("task2 exe start...");
        success = random.nextInt(2) > 0;
        log.info("task2 exe end...");
    }

}
