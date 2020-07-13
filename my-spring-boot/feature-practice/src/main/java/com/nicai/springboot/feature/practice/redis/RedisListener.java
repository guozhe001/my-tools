package com.nicai.springboot.feature.practice.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
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

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("RedisListener message.body = {}, message.channel = {}", new String(message.getBody()), new String(message.getChannel()));
    }
}
