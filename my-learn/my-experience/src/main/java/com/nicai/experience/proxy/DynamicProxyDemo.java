package com.nicai.experience.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author guozhe
 */
public class DynamicProxyDemo {

    private DynamicProxyDemo() {
    }

    static void consumer(JustAService justAService) {
        justAService.hello();
        justAService.hello("nicai");
    }

    static void testProxy() {
        consumer((JustAService) Proxy.newProxyInstance(JustAService.class.getClassLoader(),
                new Class[]{JustAService.class}, new JustAInvocationHandler(new JustAServiceImpl())));
    }
}
