package com.nicai.springboot.feature.practice.controller;

import com.nicai.springboot.feature.practice.BaseWithWebTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guozhe
 * @date 2020/7/13
 */
public class RedisControllerTest extends BaseWithWebTest {

    @Autowired
    private RedisController redisController;

    @Test
    public void publish() throws InterruptedException {
        redisController.publish();
        Assert.assertTrue(true);
    }
}