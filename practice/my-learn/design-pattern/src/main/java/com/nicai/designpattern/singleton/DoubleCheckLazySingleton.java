package com.nicai.designpattern.singleton;

/**
 * 双重检查模式
 * 方法块里面加同步，但是同步还是效率太低
 *
 * @author guozhe
 */
public class DoubleCheckLazySingleton {

    private static DoubleCheckLazySingleton instance;

    private DoubleCheckLazySingleton() {

    }

    public static DoubleCheckLazySingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
