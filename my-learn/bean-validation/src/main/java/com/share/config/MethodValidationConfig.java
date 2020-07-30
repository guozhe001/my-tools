package com.share.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 能够在方法上拦截bean validation规范的校验
 *
 * @author guozhe
 * @date 2019-12-04
 */
@Configuration
public class MethodValidationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}