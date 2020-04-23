/**
 * 拦截器模式：主要包含以下角色
 * <p>
 * TargetInvocation：包含了一组Interceptor和一个Target对象，确保在Target处理请求前后，按照定义顺序调用Interceptor做前置和后置处理
 * <p>
 * Target：处理请求的目标接口
 * <p>
 * TargetImpl：实现了Target接口的对象
 * <p>
 * Interceptor：拦截器接口
 * <p>
 * AuditInterceptorImpl：拦截器实现，用来在Target处理请求前后做切面处理
 *
 * @author guozhe
 * @date 2020-04-23
 */
package com.nicai.designpattern.interceptor;