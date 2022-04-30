package com.nicai.experience.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池相关的工具方法
 *
 * @author guozhe
 */
public class ThreadPoolUtil {

    private ThreadPoolUtil() {
    }

    /**
     * 等待所有的线程全部终止
     * 就算里面是守护线程没有终止也会一直循环
     *
     * @param executorService 线程池
     */
    public static void waitAllThreadDone(ExecutorService executorService) {
        // 关闭线程池不再能够添加新的任务
        executorService.shutdown();
        // 检查线程池是否全部任务都已经执行结束，如果执行结束则跳出循环
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
    }

    /**
     * 根据指定的线程名称和核心线程池大小创建线程池
     *
     * @param threadNameFormat 线程名称模版
     * @param corePoolSize     核心线程池大小
     * @return 线程池
     */
    public static ExecutorService getThreadPoolExecutor(String threadNameFormat, int corePoolSize) {
        return new ThreadPoolExecutor(corePoolSize, corePoolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024),
                new ThreadFactoryBuilder().setNameFormat(threadNameFormat).build());
    }

}
