package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SimpleDaemonsTest {

    @Test
    public void run() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        log.info("all daemon is started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}