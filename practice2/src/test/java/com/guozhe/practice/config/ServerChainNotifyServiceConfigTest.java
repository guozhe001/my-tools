package com.guozhe.practice.config;

import com.guozhe.practice.notify.NotifyRequest;
import com.guozhe.practice.notify.NotifyResponse;
import com.guozhe.practice.notify.NotifyService;
import com.guozhe.practice.notify.NotifyServiceFtImpl;
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
@ActiveProfiles("test")
class ServerChainNotifyServiceConfigTest implements ApplicationContextAware {

    // risk.notify.channel=SERVER_CHAIN
    // risk.notify.url=https://sctapi.ftqq.com/SCT15083TCG0UuSatcAIiWj01ztylMk46.send
    // risk.notify.send=false

    private ApplicationContext applicationContext;

    private static final String DEFAULT_NOTIFY_SERVICE_BEAN_NAME = "defaultNotifyService";
    private static final String SERVER_CHAIN_NOTIFY_SERVICE_BEAN_NAME = "serverChainNotifyService";

    @Test
    void serverChainNotifyService_NotHave1() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(DEFAULT_NOTIFY_SERVICE_BEAN_NAME));

        Object serverChainNotifyService = applicationContext.getBean(SERVER_CHAIN_NOTIFY_SERVICE_BEAN_NAME);
        Assertions.assertNotNull(serverChainNotifyService);
        Assertions.assertEquals(NotifyServiceFtImpl.class, serverChainNotifyService.getClass());

        NotifyService<NotifyRequest, NotifyResponse> bean = applicationContext.getBean(NotifyService.class);
        Assertions.assertNotNull(bean);
        log.info("NotifyService class name ={}", bean.getClass());
        Assertions.assertEquals(NotifyServiceFtImpl.class, bean.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}