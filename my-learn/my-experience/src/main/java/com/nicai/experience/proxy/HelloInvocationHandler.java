package com.nicai.experience.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理处理类
 *
 * @author guozhe
 */
@Slf4j
public class HelloInvocationHandler implements InvocationHandler {

    private final HelloService helloService;

    public HelloInvocationHandler(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("this is JustAInvocationHandler, then invoke justAService");
        return method.invoke(helloService, args);
    }
}
