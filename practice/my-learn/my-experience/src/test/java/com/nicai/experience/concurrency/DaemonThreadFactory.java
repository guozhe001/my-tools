package com.nicai.experience.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * 守护线程线程工厂
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }

}
