package com.nicai.experience.concurrency;

public class SimplePriority implements Runnable {

    /**
     * 循环次数
     */
    private int countDown = 5;
    /**
     * 优先级
     */
    private int priority;
    private volatile double d;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI * +Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }
}
