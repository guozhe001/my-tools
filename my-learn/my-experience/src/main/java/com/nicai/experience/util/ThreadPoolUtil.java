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

    public static ExecutorService getThreadPoolExecutor(String threadNameFormat, int corePoolSize) {
        return new ThreadPoolExecutor(corePoolSize, corePoolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024),
                new ThreadFactoryBuilder().setNameFormat(threadNameFormat).build());
    }

}
