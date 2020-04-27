package com.nicai.springboot.feature.practice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RestTemplateConfig {

    private final RestTemplateProperties restTemplateProperties;

    public RestTemplateConfig(RestTemplateProperties restTemplateProperties) {
        this.restTemplateProperties = restTemplateProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        log.info("RestTemplateProperties serverUrl={}, clientId={}, secret={}", restTemplateProperties.getServerUrl(), restTemplateProperties.getClientId(), restTemplateProperties.getSecret());
        return null;
    }
}
