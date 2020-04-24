package com.nicai.designpattern.singleton;

/**
 * 懒汉式
 * 非线程安全
 *
 * @author guozhe
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
