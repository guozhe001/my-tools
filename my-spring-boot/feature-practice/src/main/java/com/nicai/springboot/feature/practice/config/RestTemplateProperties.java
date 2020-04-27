package com.nicai.springboot.feature.practice.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author guozhe
 * @date 2020-04-23
 */
@Setter
@Getter
@Validated
@ConfigurationProperties("spring.oauth2.rest.template")
public class RestTemplateProperties {

    @NotBlank
    private String serverUrl;
    @NotBlank
    private String clientId;
    @NotNull
    private String secret;

}
