package com.nicai.experience.other;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

/**
 * @author guozhe
 * @date 2020-04-14
 */
@Slf4j
public class LoggerTest {

    private static final List<Person> LIST = JSON.parseArray("[{\"id\":1,\"name\":\"lilei\"},{\"id\":2,\"name\":\"hanmeimei\"}]", Person.class);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @After
    public void cleanLog() {
        systemOutRule.clearLog();
    }

    @Test
    public void test_invoke() {
        // 就算是debug日志级别也会调用getJsonString方法，如果此方法的耗时较长就是白白浪费性能
        log.debug("list={}", getJsonString(LIST));
        Assert.assertFalse(systemOutRule.getLog().contains("list="));
        Assert.assertTrue(systemOutRule.getLog().contains("getJsonString invoked"));
    }

    @Test
    public void test_not_invoke() {
        if (log.isDebugEnabled()) {
            log.debug("list={}", JSON.toJSONString(LIST));
        }
        Assert.assertFalse(systemOutRule.getLog().contains("list="));
        Assert.assertFalse(systemOutRule.getLog().contains("getJsonString invoked"));
    }

    private static String getJsonString(Object o) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("getJsonString invoked");
        return JSON.toJSONString(o);
    }


}
