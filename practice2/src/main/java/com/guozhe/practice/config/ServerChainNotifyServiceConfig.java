package com.guozhe.practice.config;

import com.guozhe.practice.notify.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * 通知服务配置
 *
 * @author guozhe
 * @date 2022/4/29
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(NotifyConfigProperties.class)
public class ServerChainNotifyServiceConfig {

    @Bean
    @ConditionalOnProperty(prefix = "risk.notify", value = {"send", "channel"})
    public NotifyServiceFtImpl serverChainNotifyService(NotifyConfigProperties notifyConfigProperties, RestTemplate restTemplate) {
        if (Objects.equals(NotifyConfigProperties.CHANNEL_SERVER_CHAIN, notifyConfigProperties.getChannel())) {
            log.info("init NotifyService NotifyServiceFtImpl.......");
            return new NotifyServiceFtImpl(restTemplate, notifyConfigProperties.getUrl());
        } else {
            throw new RuntimeException("目前近支持server chain通道的通知");
        }
    }

    @Bean
    @ConditionalOnProperty(prefix = "risk.notify", value = "send", havingValue = "false", matchIfMissing = true)
    public NotifyService<NotifyRequest, NotifyResponse> defaultNotifyService() {
        log.info("init NotifyService NotifyServiceNotSendImpl.......");
        return new NotifyServiceNotSendImpl();
    }
}
