package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * Runnable练习-倒计时
 *
 * @author guozhe
 */
@Slf4j
public class LiftOff implements Runnable {

    /**
     * 倒计时的开始时间
     */
    private int cycleTimes = 10;
    /**
     * 所有实例共享
     */
    private static int count = 0;

    /**
     * 一旦一个实例创建则id固定，并且每个实例的id不同
     */
    private final int id = count++;


    @Override
    public void run() {
        while (cycleTimes > 0) {
            log.info("id={},cycleTimes={}", id, cycleTimes);
            cycleTimes--;
            // 我已经执行完生命周期中最重要的不分了，此时是正是切换给其他任务执行一段时间的大好时机
            Thread.yield();
        }
    }

}
