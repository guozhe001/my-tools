package com.nicai.designpattern.singleton;

import org.springframework.util.Assert;

/**
 * 内部类懒加载单例
 * 实例保存在私有的内部类中，内部类是懒加载的，此方法几乎最好
 *
 * @author guozhe
 */
public class InnerClassLazySingleton {

    private InnerClassLazySingleton() {
        // 加此校验为了防止反射创建此类
        Assert.isNull(InstanceHolder.INSTANCE, "单例模式只能创建一个实例");
    }

    public static InnerClassLazySingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final InnerClassLazySingleton INSTANCE = new InnerClassLazySingleton();
    }
}
