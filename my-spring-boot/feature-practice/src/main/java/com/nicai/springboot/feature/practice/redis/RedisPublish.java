package com.nicai.springboot.feature.practice.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis发布
 *
 * @author guozhe
 * @date 2020/7/13
 */
@Slf4j
@Component
public class RedisPublish {

    private final RedisTemplate<String, String> redisTemplate;


    public RedisPublish(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(String queue, String message) {
        log.info("RedisPublish queue={}, message={}", queue, message);
        redisTemplate.convertAndSend(queue, message);
    }
}
