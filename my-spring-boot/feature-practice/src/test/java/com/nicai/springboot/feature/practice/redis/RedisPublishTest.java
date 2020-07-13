package com.nicai.springboot.feature.practice.redis;

import com.nicai.springboot.feature.practice.BaseNoWebTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author guozhe
 * @date 2020/7/13
 */
public class RedisPublishTest extends BaseNoWebTest {
    @Autowired
    private RedisPublish redisPublish;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String KEY = "hello";
    private static final String VALUE = "world";

    @Test
    public void setAndGet() {
        redisTemplate.opsForValue().set(KEY, VALUE);
        String value = redisTemplate.opsForValue().get(KEY);
        Assert.assertEquals(VALUE, value);
    }

    @Test
    public void publish() throws InterruptedException {
        redisTemplate.opsForValue().set(KEY, VALUE);
        redisPublish.publish(RedisListener.CHANNEL, KEY);
        // 等待一秒钟，等待消费者
        TimeUnit.MILLISECONDS.sleep(1000L);
        Assert.assertTrue(true);
    }


}