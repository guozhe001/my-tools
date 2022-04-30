package com.guozhe.practice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 通知类属性配置类
 *
 * @author guozhe
 * @date 2022/4/29
 */
@Data
@ConfigurationProperties(prefix = "risk.notify")
public class NotifyConfigProperties {

    /**
     * server酱通道
     */
    public static final String CHANNEL_SERVER_CHAIN = "SERVER_CHAIN";

    /**
     * 通道
     */
    private String channel;

    /**
     * 通知url
     */
    private String url;

    /**
     * 是否发送
     */
    private Boolean send;
}
