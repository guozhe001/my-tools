package com.nicai.springboot.feature.practice.controller;

import com.nicai.springboot.feature.practice.BaseWithWebTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

/**
 *
 * @author guozhe
 * @date 2020/7/13
 */
@AutoConfigureMockMvc
public class RedisControllerTest extends BaseWithWebTest {

    @Autowired
    private RedisController redisController;

    @Test
    public void publish() {
        redisController.publish();
        Assert.assertTrue(true);
    }
}