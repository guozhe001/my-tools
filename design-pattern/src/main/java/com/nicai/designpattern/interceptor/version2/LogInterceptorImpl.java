package com.nicai.designpattern.interceptor.version2;

import com.nicai.designpattern.interceptor.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * 记录日志的拦截器：
 * <p>
 * 执行之前记录请求报文
 * <p>
 * 执行之后记录返回报文
 *
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
public class LogInterceptorImpl implements Interceptor {

    @Override
    public void before(TargetInvocation targetInvocation) {
        log.info("记录日志的拦截器-request=【{}】", targetInvocation.getRequest().toString());
    }

    @Override
    public void after(TargetInvocation targetInvocation, Response response) {
        log.info("记录日志的拦截器-response=【{}】", response.toString());
    }

}
