package com.nicai.experience.util;

/**
 * 生成器
 *
 * @author guozhe
 */
public interface Generator<T> {

    /**
     * 生成一个类
     *
     * @return 指定类型的类
     */
    T next();
}
