package com.nicai.designpattern.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
public class TargetInvocationTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void invoke() {
        String name = "han mei mei";
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new AuditInterceptorImpl());
        targetInvocation.addInterceptor(new LogInterceptorImpl());
        targetInvocation.setRequest(new MyRequest(name));
        targetInvocation.setTarget(new TargetImpl());
        targetInvocation.invoke();
        // 断言目标方法只被调用了一次
        Assert.assertEquals(1, StrUtil.count(systemOutRule.getLog(), "i'm TargetImpl"));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MyRequest implements Request {
        private String name;
    }
}