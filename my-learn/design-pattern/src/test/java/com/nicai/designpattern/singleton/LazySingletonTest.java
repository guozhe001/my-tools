package com.nicai.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class LazySingletonTest {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static final ExecutorService otherExecutorService = Executors.newFixedThreadPool(1);

    @Test
    public void getInstance() {
        // 打印的实例有可能不一样
        executorService.execute(() -> log.info("instance={}", LazySingleton.getInstance()));
        otherExecutorService.execute(() -> log.info("instance1={}", LazySingleton.getInstance()));
    }
}

