package com.nicai.designpattern.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020-04-23
 */
public class TargetInvocationTest {

    @Test
    public void invoke() {
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new AuditInterceptorImpl());
//        targetInvocation.addInterceptor(new LogInterceptorImpl());
        targetInvocation.setRequest(new MyRequest("han mei mei"));
        targetInvocation.setTarget(new TargetImpl());
        targetInvocation.invoke();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MyRequest implements Request {
        private String name;
    }
}