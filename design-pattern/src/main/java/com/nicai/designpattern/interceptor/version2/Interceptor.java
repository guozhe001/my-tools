package com.nicai.designpattern.interceptor.version2;

import com.nicai.designpattern.interceptor.Response;

/**
 * 拦截器接口
 *
 * @author guozhe
 * @date 2020-04-23
 */
public interface Interceptor {

    /**
     * 在调用目标方法之前要做的事情
     *
     * @param targetInvocation 被拦截的类的调用方法
     */
    void before(TargetInvocation targetInvocation);

    /**
     * 拦截目标方法
     *
     * @param targetInvocation 被拦截的类的调用方法
     * @return 目标方法的返回值
     */
    default Response intercept(TargetInvocation targetInvocation) {
        before(targetInvocation);
        Response response = targetInvocation.invoke();
        after(targetInvocation, response);
        return response;
    }

    /**
     * 在调用目标方法之后要做的事情
     *
     * @param targetInvocation 被拦截的类的调用方法
     * @param response         目标方法的返回值
     */
    void after(TargetInvocation targetInvocation, Response response);
}
