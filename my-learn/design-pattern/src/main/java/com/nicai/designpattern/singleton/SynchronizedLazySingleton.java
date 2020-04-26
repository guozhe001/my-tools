package com.nicai.designpattern.singleton;

/**
 * 方法上加同步，可以解决线程安全问题，但是效率会变低
 *
 * @author guozhe
 */
public class SynchronizedLazySingleton {

    private static SynchronizedLazySingleton instance;

    private SynchronizedLazySingleton() {
    }

    public static synchronized SynchronizedLazySingleton getInstance() {
        if (null == instance) {
            instance = new SynchronizedLazySingleton();
        }
        return instance;
    }
}
