package com.nicai.experience.proxy;

import org.junit.Test;

public class DynamicProxyDemoTest {

    @Test
    public void testProxy() {
        DynamicProxyDemo.testProxy();
    }

    @Test
    public void consumer() {
        DynamicProxyDemo.consumer(new HelloServiceImpl());
    }

}