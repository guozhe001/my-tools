package com.guozhe.practice.config;

import com.guozhe.practice.notify.NotifyRequest;
import com.guozhe.practice.notify.NotifyResponse;
import com.guozhe.practice.notify.NotifyService;
import com.guozhe.practice.notify.NotifyServiceNotSendImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
class ServerChainNotifyServiceConfigLocalTest implements ApplicationContextAware {

    // risk.notify.channel=SERVER_CHAIN
    // risk.notify.url=https://sctapi.ftqq.com/SCT15083TCG0UuSatcAIiWj01ztylMk46.send
    // risk.notify.send=false

    private ApplicationContext applicationContext;

    private static final String DEFAULT_NOTIFY_SERVICE_BEAN_NAME = "defaultNotifyService";
    private static final String SERVER_CHAIN_NOTIFY_SERVICE_BEAN_NAME = "serverChainNotifyService";

    @Test
    void serverChainNotifyService_NotHave() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> applicationContext.getBean(SERVER_CHAIN_NOTIFY_SERVICE_BEAN_NAME));

        Object defaultNotifyService = applicationContext.getBean(DEFAULT_NOTIFY_SERVICE_BEAN_NAME);
        Assertions.assertNotNull(defaultNotifyService);
        Assertions.assertEquals(NotifyServiceNotSendImpl.class, defaultNotifyService.getClass());

        NotifyService<NotifyRequest, NotifyResponse> bean = applicationContext.getBean(NotifyService.class);
        Assertions.assertNotNull(bean);
        log.info("NotifyService class name ={}", bean.getClass());
        Assertions.assertEquals(NotifyServiceNotSendImpl.class, bean.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}