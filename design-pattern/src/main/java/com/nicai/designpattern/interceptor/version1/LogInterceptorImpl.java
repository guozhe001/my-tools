package com.nicai.designpattern.interceptor.version1;

import cn.hutool.core.lang.Assert;
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
    public Response intercept(TargetInvocation targetInvocation) {
        Assert.notNull(targetInvocation.getTarget());
        log.info("记录日志的拦截器-request=【{}】", targetInvocation.getRequest().toString());
        Response response = targetInvocation.invoke();
        log.info("记录日志的拦截器-response=【{}】", response.toString());
        return response;
    }

}
