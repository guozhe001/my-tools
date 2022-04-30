package com.nicai.experience.concurrency;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

@Slf4j
public class MyUncaughtExceptionHandlerTest {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testForEach() {
        forEachAndPrint(Lists.newArrayList("a", "b", "c", "d"));
        Assert.assertTrue(systemOutRule.getLog().contains("str="));
    }

    @Test
    public void testForEach1() {
        forEachAndPrint(Lists.newArrayList());
        Assert.assertFalse(systemOutRule.getLog().contains("str="));
    }

    @Test
    public void testForEachNull() {
        forEachAndPrint(null);
        Assert.assertFalse(systemOutRule.getLog().contains("str="));
    }

    @After
    public void cleanLog() {
        systemOutRule.clearLog();
    }

    private void forEachAndPrint(List<String> list) {
        if (CollectionUtil.isNotEmpty(list)) {
            list.forEach(str -> log.info("str={}", str));
        }
    }
}