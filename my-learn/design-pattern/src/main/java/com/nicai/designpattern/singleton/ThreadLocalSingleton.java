package com.nicai.designpattern.singleton;

/**
 * 线程单例
 * 不同线程的实例是不同的，相同线程的实例是相同的；以空间换时间
 *
 * @author guozhe
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL =
            ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL.get();
    }

    public void remove() {
        THREAD_LOCAL.remove();
    }
}
