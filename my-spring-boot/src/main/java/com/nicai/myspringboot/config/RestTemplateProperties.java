package com.nicai.myspringboot.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author guozhe
 * @date 2020-04-23
 */
@Setter
@Getter
@ConfigurationProperties("spring.oauth2.rest.template")
public class RestTemplateProperties {

    private String serverUrl;
    private String clientId;
    private String secret;

}
