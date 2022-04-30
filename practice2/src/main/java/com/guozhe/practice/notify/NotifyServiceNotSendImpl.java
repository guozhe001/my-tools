package com.guozhe.practice.notify;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 不需要发送消息的实现类
 * 
 * @author guozhe
 * @date 2022/4/29
 */
@Slf4j
public class NotifyServiceNotSendImpl implements NotifyService<NotifyRequest, NotifyResponse> {

    @Override
    public NotifyResponse notify(NotifyRequest request) {
        if (log.isWarnEnabled()) {
            log.warn("no need to notify, message={}", JSON.toJSONString(request));
        }
        return new NotifyResponse() {};
    }
}
