package com.nicai.springboot.feature.practice.controller;

import com.nicai.springboot.feature.practice.redis.RedisListener;
import com.nicai.springboot.feature.practice.redis.RedisPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author guozhe
 * @date 2020/7/13
 */
@Slf4j
@Controller
@RequestMapping("/api/redis/")
public class RedisController {

    private static final int PUBLISH_TIMES = 5;
    private final RedisPublish redisPublish;

    public RedisController(RedisPublish redisPublish) {
        this.redisPublish = redisPublish;
    }

    @PostMapping("publish")
    @ResponseBody
    public void publish() throws InterruptedException {
        for (int i = 0; i < PUBLISH_TIMES; i++) {
            try {
                // 等待监听器接收到
                TimeUnit.MILLISECONDS.sleep(100L);
            } catch (InterruptedException e) {
                log.error("Interrupted error_message = {}", e.getMessage(), e);
                throw e;
            }
            redisPublish.publish(RedisListener.CHANNEL, String.format("message-%s", i));
        }
    }
}
