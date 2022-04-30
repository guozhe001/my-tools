package com.nicai.constant;

import cn.hutool.core.util.StrUtil;

/**
 * RedisConstants
 *
 * @author guozhe
 * @date 2020/08/07
 */
public class RedisConstants {

    private RedisConstants() {
    }

    /**
     * redis的key前缀
     */
    public static final String KEY_PREFIX = "NICAI-PLATFORM";

    /**
     * redis的key的定界符
     */
    public static final String KEY_DELIMITER = StrUtil.COLON;
}
