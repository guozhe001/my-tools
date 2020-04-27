package com.nicai.springboot.feature.practice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 测试自动注册监听器,需要在META-INF/spring.factories中配置
 *
 * @author guozhe
 * @date 2020-04-26
 */
@Slf4j
public class MyListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("MyListener,onApplicationEvent event.getSource()={}", event.getSource());
    }
}
