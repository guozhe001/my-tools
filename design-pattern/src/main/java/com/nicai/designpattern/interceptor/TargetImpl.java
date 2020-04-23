package com.nicai.designpattern.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 被拦截的实现
 *
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
public class TargetImpl implements Target {

    @Override
    public Response executeBiz(Request request) {
        if (log.isInfoEnabled()) {
            log.info("i'm TargetImpl, requestIs={}", request.toString());
        }
        return new MyResponse(1, "success");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MyResponse implements Response {
        /**
         * 返回码
         */
        private Integer code;

        /**
         * 返回信息
         */
        private String message;

    }
}
