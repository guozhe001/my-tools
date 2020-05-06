package com.nicai.experience.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhe
 * @date 2020-05-06
 */
public class ThreadPoolUtils {

    private ThreadPoolUtils() {

    }

    public static ExecutorService getThreadPoolExecutor(String threadNameFormat, int corePoolSize) {
        return new ThreadPoolExecutor(corePoolSize, corePoolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024),
                new ThreadFactoryBuilder().setNameFormat(threadNameFormat).build());
    }

}
