package com.nicai.experience.concurrency;

import com.google.common.collect.Lists;
import com.nicai.experience.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class TaskWithResultTest {

    @Test
    public void call() {
        List<Future<String>> results = Lists.newArrayList();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult()));
        }
        for (Future<String> future : results) {
            try {
                log.info("result={}", future.get());
            } catch (Exception e) {
                log.error("error_message={}", e.getMessage(), e);
            } finally {
                ThreadPoolUtil.waitAllThreadDone(executorService);
            }
        }
    }
}