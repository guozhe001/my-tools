package com.nicai.experience.util;

import com.nicai.experience.exception.NicaiException;
import lombok.extern.slf4j.Slf4j;

/**
 * 基础的生成器实现
 *
 * @author guozhe
 */
@Slf4j
public class BasicGenerator<T> implements Generator<T> {

    /**
     * 需要生成的类型
     */
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return this.type.newInstance();
        } catch (Exception e) {
            log.error("type={} 生成新的实例异常，error_message={}", type.getName(), e.getMessage(), e);
            throw new NicaiException(e);
        }
    }

    /**
     * 创建一个通用的生成器
     *
     * @param type 生成器生成实例的类型
     * @param <T>  类型
     * @return 生成器
     */
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

}
