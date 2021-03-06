package com.nicai.designpattern.interceptor.version2;

import cn.hutool.core.lang.Assert;
import com.nicai.designpattern.interceptor.Response;
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
    public void before(TargetInvocation targetInvocation) {
        Assert.notNull(targetInvocation.getTarget());
        log.info("审计拦截器执行成功");
    }

    @Override
    public void after(TargetInvocation targetInvocation, Response response) {
        // do nothing
    }

}
