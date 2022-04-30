package com.nicai.springboot.feature.practice.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis队列监听器
 *
 * @author guozhe
 * @date 2020/7/13
 */
@Slf4j
@Component
public class RedisListener implements MessageListener {

    /**
     * 监听的渠道
     */
    public static final String CHANNEL = "channel:hello";

    private final RedisTemplate<String, String> redisTemplate;

    public RedisListener(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = new String(message.getBody());
        log.info("RedisListener message.body = {}, message.channel = {}, pattern = {}", key, new String(message.getChannel()),
                new String(pattern));
        String value = redisTemplate.opsForValue().get(key);
        log.info("redis key = {}, value = {}", key, value);
    }
}
