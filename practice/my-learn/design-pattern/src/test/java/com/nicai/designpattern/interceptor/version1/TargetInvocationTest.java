package com.nicai.designpattern.interceptor.version1;

import cn.hutool.core.util.StrUtil;
import com.nicai.designpattern.interceptor.Request;
import com.nicai.designpattern.interceptor.TargetImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * @author guozhe
 * @date 2020-04-23
 */
@Slf4j
public class TargetInvocationTest {

    private static final String NAME = "han mei mei";

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private static TargetInvocation targetInvocation;

    @BeforeClass
    public static void init() {
        targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new AuditInterceptorImpl());
        targetInvocation.addInterceptor(new LogInterceptorImpl());
        targetInvocation.setRequest(new MyRequest(NAME));
        targetInvocation.setTarget(new TargetImpl());
    }

    @Test
    public void invoke_version1() {
        printLine("invoke_version1");
        log.info("targetInvocation={}", targetInvocation.toString());
        targetInvocation.invoke();
        // 断言目标方法只被调用了一次
        Assert.assertEquals(1, StrUtil.count(systemOutRule.getLog(), "i'm TargetImpl"));
    }

    @Test
    public void invoke_version2() {
        printLine("invoke_version2");
        log.info("targetInvocation={}", targetInvocation.toString());
        com.nicai.designpattern.interceptor.version2.TargetInvocation targetInvocation = new com.nicai.designpattern.interceptor.version2.TargetInvocation();
        targetInvocation.addInterceptor(new com.nicai.designpattern.interceptor.version2.AuditInterceptorImpl());
        targetInvocation.addInterceptor(new com.nicai.designpattern.interceptor.version2.LogInterceptorImpl());
        targetInvocation.setRequest(new MyRequest(NAME));
        targetInvocation.setTarget(new TargetImpl());
        targetInvocation.invoke();
        // 断言目标方法只被调用了一次
        Assert.assertEquals(1, StrUtil.count(systemOutRule.getLog(), "i'm TargetImpl"));
    }


    private void printLine(String testName) {
        log.info("{}===================================", testName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MyRequest implements Request {
        private String name;
    }
}