package com.nicai.designpattern.interceptor;

import com.nicai.designpattern.interceptor.Request;
import com.nicai.designpattern.interceptor.Response;

/**
 * 被拦截的接口
 *
 * @author guozhe
 * @date 2020-04-23
 */
public interface Target {

    /**
     * 处理业务
     *
     * @param request 请求数据
     * @return 返回数据
     */
    Response executeBiz(Request request);
}
