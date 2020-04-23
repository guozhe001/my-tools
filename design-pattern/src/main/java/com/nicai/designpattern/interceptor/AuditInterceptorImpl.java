package com.nicai.designpattern.interceptor;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

/**
 * 审计拦截器
 * <p>
 * 审查target不能为null
 *
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
public class AuditInterceptorImpl implements Interceptor {

    @Override
    public Response intercept(TargetInvocation targetInvocation) {
        Assert.notNull(targetInvocation.getTarget());
        log.info("审计拦截器执行成功");
        return targetInvocation.invoke();
    }

}
