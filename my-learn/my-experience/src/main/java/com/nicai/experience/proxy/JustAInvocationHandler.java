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
public class JustAInvocationHandler implements InvocationHandler {

    private JustAService justAService;

    public JustAInvocationHandler(JustAService justAService) {
        this.justAService = justAService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("this is JustAInvocationHandler, then invoke justAService");
        return method.invoke(justAService, args);
    }
}
