package com.nicai.designpattern.interceptor;

/**
 * 拦截器接口
 *
 * @author guozhe
 * @date 2020-04-23
 */
public interface Interceptor {

    Response intercept(TargetInvocation targetInvocation);
}
