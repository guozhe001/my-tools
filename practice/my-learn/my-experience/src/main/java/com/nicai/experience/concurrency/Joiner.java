package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guozhe
 */
@Slf4j
public class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            log.error("Interrupted");
        }
        log.info("{} join completed", getName());
    }
}
