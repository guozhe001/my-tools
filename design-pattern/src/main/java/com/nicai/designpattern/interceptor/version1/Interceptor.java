package com.nicai.designpattern.interceptor.version1;

import com.nicai.designpattern.interceptor.Response;

/**
 * 拦截器接口
 *
 * @author guozhe
 * @date 2020-04-23
 */
public interface Interceptor {

    Response intercept(TargetInvocation targetInvocation);
}
