package com.nicai.springboot.feature.practice.service;

import cn.hutool.core.util.BooleanUtil;
import com.alibaba.fastjson.JSON;
import com.nicai.springboot.feature.practice.bo.Context;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 分布式ID生成服务
 *
 * @author guozhe
 * @date 2020/08/04
 */
@Slf4j
public abstract class AbstractRedisDistributedIDGenerateService<T extends Context> {

    /**
     * 初始化key时的默认值
     */
    private static final long DEFAULT_VALUE = 0;

    protected final StringRedisTemplate redisTemplate;

    public AbstractRedisDistributedIDGenerateService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取下一个ID，直接从redis中获取自增后的值；
     *
     * @return 下一个ID, 如果redis出现异常则返回null，请使用者自行处理
     */
    public final Optional<Long> nextId() {
        // 从redis中获取自增id
        Long id = incr(getKey());
        return Objects.isNull(id) ? Optional.empty() : Optional.of(id);
    }

    /**
     * 获取下一个ID，根据传入的上下文和redis中自增后的值最终组装成下一个ID；
     * 获取之后会交给子类检查此ID是否重复，如果重复会从子类中获取最新的ID，然后更新redis中的值
     *
     * @param context 拼装id时需要的上下文
     * @return 下一个ID
     */
    public final String nextId(T context) {
        Optional<Long> id = nextId();
        // 如果可以从redis中获取值，则说明redis服务正常，需要判重；否则直接从数据库中获取下一个id
        String nextId = id.isPresent() ? ifDuplicatedThenUpdate(context, assemblyNextId(context, id.get())) :
                getNewIdFromDbAndUpdateRedis(context, null);
        if (log.isDebugEnabled()) {
            log.debug("context={},redisIncrId={} nextId={}", JSON.toJSONString(context), id, nextId);
        }
        return nextId;
    }

    /**
     * 检查获取到的ID是否重复
     * 如果重复则说明由于redis的一些原因导致的重复，返回最新的redis中应该存在的值
     *
     * @param nextId 下一个ID
     * @return 如果当前ID没有重复，则返回null，否则如果重复了则返回redis中应该有的值
     */
    protected abstract boolean checkIfDuplicated(String nextId);

    /**
     * 从数据库获取下一个id
     *
     * @param duplicatedId 重复的id，此入参可能为null，子类需要自己处理
     * @return 数据库获取下一个id
     */
    protected abstract Long maxIdFromDatabase(String duplicatedId);

    /**
     * 子类根据redis当前的值自行组装最终的ID
     *
     * @param context    上下文
     * @param redisValue redis当前的值
     * @return 最终的ID
     */
    protected abstract String assemblyNextId(T context, Long redisValue);

    /**
     * 获取redis自增的key
     *
     * @return redis自增的key
     */
    protected abstract String getKey();

    /**
     * 调用redis的自增方法
     * 如果key不存在则先设置key，再调用自增方法
     *
     * @param key 需要自增的key
     * @return 自增之后的值，如果redis出现异常则返回null
     */
    Long incr(String key) {
        Long increment = null;
        try {
            // 先检查redis中是否有key,如果没有,先设置key并且设置过期时间
            if (BooleanUtil.isFalse(redisTemplate.hasKey(key))) {
                initOrUpdateValue(key, getKeyInitValue());
            }
            increment = redisTemplate.opsForValue().increment(key);
        } catch (Exception e) {
            log.error("调用redis的自增方法异常，error_message={}", e.getMessage(), e);
        }
        log.debug("key = {}, increment={}", key, increment);
        return increment;
    }

    /**
     * 获取初始化key时的value值，默认是0，自增之后id从1开始；
     * 如果子类想从其他数字开始则自己覆盖此方法即可
     *
     * @return 初始化key时的value值
     */
    protected long getKeyInitValue() {
        return DEFAULT_VALUE;
    }

    /**
     * 获取key的超时时间，单位是小时，由子类设置
     *
     * @return 超时时间，单位小时
     */
    protected abstract long getTimeOutHours();

    /**
     * 判断是否重复，如果重复则从别的渠道（由子类自己决定从哪个渠道）更新
     *
     * @param context 拼装id时需要的上下文
     * @param nextId  下一个id
     * @return 如果重复则返回新的nextId，否则返回入参传入的nextId
     */
    private String ifDuplicatedThenUpdate(T context, String nextId) {
        // 判断是否重复，如果重复则从数据库中获取，否则直接返回当前值
        return checkIfDuplicated(nextId) ? getNewIdFromDbAndUpdateRedis(context, nextId) : nextId;
    }

    /**
     * 从数据库获取新id并更新redis中的值
     *
     * @param context 拼装id时需要的上下文
     * @param nextId  下一个id
     * @return 根据数据库的id获得的新id
     */
    private String getNewIdFromDbAndUpdateRedis(T context, String nextId) {
        Long maxIdFromDatabase = maxIdFromDatabase(nextId);
        String newId = assemblyNextId(context, maxIdFromDatabase);
        log.warn("nextId={} 在数据库中已经存在，maxIdFromDatabase={} 重新获取新的newId={}", nextId, maxIdFromDatabase, newId);
        initOrUpdateValue(getKey(), maxIdFromDatabase);
        return newId;
    }

    /**
     * 初始化或者更新redis中的自增的值
     *
     * @param key   redis中的key
     * @param value 需要设置的值
     */
    private void initOrUpdateValue(String key, Long value) {
        try {
            redisTemplate.opsForValue().set(key, String.valueOf(value), getTimeOutHours(), TimeUnit.HOURS);
        } catch (Exception e) {
            log.error("设置redis值异常，value={} error_message={}", value, e.getMessage(), e);
        }
    }
}

