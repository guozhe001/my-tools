package com.guozhe.practice.notify;

/**
 * 通知服务
 *
 * @author guozhe
 */
public interface NotifyService<T extends NotifyRequest, D extends NotifyResponse> {

    /**
     * 通知
     *
     * @param request 通知请求
     * @return 通知响应
     */
    D notify(T request);

}
