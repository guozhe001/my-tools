package com.nicai.experience.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 没有响应的UI
 *
 * @author guozhe
 */
@Slf4j
public class ResponsiveUi extends Thread {

    private static volatile double d = 1;

    public ResponsiveUi() {
        setDaemon(true);

    }

    @Override
    public void run() {
        while (d > 0) {
            d = d + (Math.E + Math.PI) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        ResponsiveUi responsiveUi = new ResponsiveUi();
        responsiveUi.start();
        System.in.read();
        log.info("d={}", d);
    }
}
