package com.nicai.designpattern.singleton;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020-04-24
 */
@Slf4j
public class ThreadLocalSingletonTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final ThreadFactory threadFactory = new ThreadFactory() {
        private AtomicInteger i = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "test-ThreadLocalSingleton-" + i.incrementAndGet());
        }
    };

    private static final ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>() {
            }, threadFactory);

    @Test
    public void getInstance() throws InterruptedException {
        List<ThreadInstance> threadInstances = Lists.newArrayList();
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> {
            ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
            log.info("instance={}", instance);
            threadInstances.add(new ThreadInstance(Thread.currentThread().getName(), instance));
        }));
//        String logs = systemOutRule.getLog();
//        String[] split = StringUtils.split(logs, '\n');
//        for (String logLine : split) {
//            System.out.println(logLine);
//        }
        Thread.sleep(1000L);
        Map<String, List<ThreadInstance>> collect = threadInstances.stream().collect(Collectors.groupingBy(ThreadInstance::getThreadName));
        collect.forEach((k, v) -> {
            log.info("k={},value size={}", k, v.size());
            check(v);
        });
    }

    private void check(List<ThreadInstance> v) {
        Iterator<ThreadInstance> iterator = v.iterator();
        ThreadInstance next = iterator.next();
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ThreadInstance {
        private String threadName;
        private ThreadLocalSingleton threadLocalSingleton;
    }
}