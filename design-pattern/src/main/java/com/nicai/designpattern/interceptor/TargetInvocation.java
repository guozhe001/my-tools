package com.nicai.designpattern.interceptor;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author guozhe
 * @date 2020-04-23
 */
public class TargetInvocation {

    /**
     * 拦截器列表
     */
    private List<Interceptor> interceptors = Lists.newArrayList();

    /**
     * 被拦截的类
     */
    private Target target;

    private Iterator<Interceptor> interceptorIterator = interceptors.iterator();

    /**
     * 当前的Target请求
     */
    private Request request;

    /**
     * 添加一个拦截器
     *
     * @param interceptor 拦截器
     */
    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
        interceptorIterator = interceptors.iterator();
    }

    public Response invoke() {
        if (interceptorIterator.hasNext()) {
            Interceptor interceptor = interceptorIterator.next();
            interceptor.intercept(this);
        }
        return target.executeBiz(request);
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
