package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guozhe
 */
@Slf4j
public class Sleeper extends Thread {

    /**
     * 睡眠时间
     */
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            log.info("{} was interrupted, isInterrupted()={}", getName(), isInterrupted());
        }
        log.info("{} has awakened", getName());
    }
}
