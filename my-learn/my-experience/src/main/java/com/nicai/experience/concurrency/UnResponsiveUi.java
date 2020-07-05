package com.nicai.experience.concurrency;

import java.io.IOException;

/**
 * 没有响应的UI
 *
 * @author guozhe
 */
public class UnResponsiveUi {

    private volatile double d = 1;

    public UnResponsiveUi() throws IOException {
        while (d > 0) {
            d = d + (Math.E + Math.PI) / d;
        }
        // 永远无法执行到下一句
        System.in.read();
    }

}
