package com.nicai.springboot.feature.practice.controller;

import com.nicai.springboot.feature.practice.redis.RedisListener;
import com.nicai.springboot.feature.practice.redis.RedisPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020/7/13
 */
@Slf4j
@Controller
@RequestMapping("/api/redis/")
public class RedisController {

    private final RedisPublish redisPublish;

    public RedisController(RedisPublish redisPublish) {
        this.redisPublish = redisPublish;
    }

    @PostMapping("publish")
    @ResponseBody
    public void publish() {
        IntStream.range(0, 5).forEach(i -> redisPublish.publish(RedisListener.CHANNEL, String.format("message-%s", i)));
    }
}
