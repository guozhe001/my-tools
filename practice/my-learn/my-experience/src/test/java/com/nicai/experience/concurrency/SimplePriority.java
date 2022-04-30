package com.nicai.experience.concurrency;

/**
 * 线程优先级练习
 */
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
                    // 让步，只是给线程调度器一个暗示，说此线程的核心工作已经做的茶不错了，可以让给别的线程使用cpu了；但是这个暗示或者建议并不一定被线程调度器所采纳
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
