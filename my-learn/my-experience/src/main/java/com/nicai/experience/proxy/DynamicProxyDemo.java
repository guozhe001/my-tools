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

    static void consumer(HelloService helloService) {
        helloService.hello();
        helloService.hello("nicai");
    }

    static void testProxy() {
        consumer((HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                new Class[]{HelloService.class}, new HelloInvocationHandler(new HelloServiceImpl())));
    }
}
