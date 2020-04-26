package com.nicai.designpattern.singleton;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020-04-24
 */
@Slf4j
public class ThreadLocalSingletonTest {

    /**
     * 线程池的最大线程数量
     */
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final String THREAD_NAME_FORMAT = "test-ThreadLocalSingleton-%s";

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final ThreadFactory threadFactoryByGuava = new ThreadFactoryBuilder().setNameFormat(THREAD_NAME_FORMAT).build();

    private static final ExecutorService executorService = new ThreadPoolExecutor(MAXIMUM_POOL_SIZE, MAXIMUM_POOL_SIZE, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>() {
            }, threadFactoryByGuava);

    @Test
    public void getInstance() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<ThreadInstance> threadInstances = Lists.newArrayList();
        // 使用线程池执行1000次获取instance
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> threadInstances.add(new ThreadInstance(Thread.currentThread().getName(), ThreadLocalSingleton.getInstance()))));
        waitAllThreadDone(stopwatch);
//        Map<String, List<ThreadInstance>> collect = threadInstances.stream().collect(Collectors.groupingBy(ThreadInstance::getThreadName));
//        collect.forEach((threadName, threadInstanceList) -> {
//            log.info("threadName={} size={}", threadName, threadInstanceList.size());
//            check(threadInstanceList);
//        });
    }


    private void waitAllThreadDone(Stopwatch stopwatch) {
        executorService.shutdown();
        // 等待所有的线程执行结束
        while (true) {
            if (executorService.isTerminated()) {
                log.info("all task is done spend {} MILLISECONDS", stopwatch.elapsed(TimeUnit.MILLISECONDS));
                break;
            }
        }
    }

    /**
     * 校验列表中的实例是相同的
     *
     * @param threadInstances 实例列表
     */
    private void check(List<ThreadInstance> threadInstances) {
        Iterator<ThreadInstance> iterator = threadInstances.iterator();
        ThreadInstance first = iterator.next();
        if (iterator.hasNext()) {
            ThreadInstance next = iterator.next();
            Assert.assertEquals(first, next);
        }
    }

    @Data
    @NoArgsConstructor
    public class ThreadInstance {
        ThreadInstance(String threadName, ThreadLocalSingleton threadLocalSingleton) {
            cn.hutool.core.lang.Assert.notNull(threadName);
            this.threadName = threadName;
            this.threadLocalSingleton = threadLocalSingleton;
        }

        private String threadName;
        private ThreadLocalSingleton threadLocalSingleton;
    }
}