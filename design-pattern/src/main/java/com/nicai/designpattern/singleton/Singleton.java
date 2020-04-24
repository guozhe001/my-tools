package com.nicai.designpattern.singleton;

/**
 * 饿汉式
 *
 * @author guozhe
 */
public class Singleton {
    /**
     * 类初始化时就创建实例，不论是否会使用
     */
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
