package com.nicai.experience.util;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串拼接测试
 *
 * @author guozhe
 * @date 2020/07/14
 */
@Slf4j
public class JoinTest {
    /**
     * 分割符
     */
    private static final String SPLIT = StrUtil.COMMA;

    /**
     * 需要拼接的字符串列表
     */
    private static final List<String> TO_BE_JOIN_LIST = Lists.newArrayList("a", "b", "c", "d", "e");

    /**
     * 期待的结果
     */
    private static final String EXPECT_RESULT = "a,b,c,d,e";

    @Test
    public void join() {
        printAndAssert("guavaJoiner", Joiner.on(SPLIT).join(TO_BE_JOIN_LIST));
        printAndAssert("stringJoin", String.join(SPLIT, TO_BE_JOIN_LIST));
        printAndAssert("collectorsJoining", TO_BE_JOIN_LIST.stream().collect(Collectors.joining(SPLIT)));
    }

    private void printAndAssert(String type, String result) {
        Assert.assertEquals(EXPECT_RESULT, result);
        log.info("type = {} result = {}", type, result);
    }
}