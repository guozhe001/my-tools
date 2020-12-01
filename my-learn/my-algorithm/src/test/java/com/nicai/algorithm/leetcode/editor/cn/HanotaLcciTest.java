package com.nicai.algorithm.leetcode.editor.cn;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * HanotaLcciTest
 *
 * @author guozhe
 * @date 2020/09/24
 */
@Slf4j
public class HanotaLcciTest {

    /**
     * 汉诺塔阿u是你发方案
     */
    private HanotaLcci.Solution solution = new HanotaLcci().new Solution();

    /**
     * 有一个圆盘
     */
    @Test
    public void hanotaOne() {
        IntStream.range(1, 20).forEach(num -> {
            log.info("圆盘个数={}===========================", num);
            List<Integer> toBeTest = Lists.newArrayList();
            for (int i = num - 1; i >= 0; i--) {
                toBeTest.add(i);
            }
            invokeAndAssert(toBeTest, Lists.newArrayList(), Lists.newArrayList());
        });
    }

    private void invokeAndAssert(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> expect = Lists.newArrayList(a);
        log.info("expect={}", expect);
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Integer> actual = solution.hanota(a, b, c);
        log.info("actual={}, spendTime={}MILLISECONDS", actual, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

}