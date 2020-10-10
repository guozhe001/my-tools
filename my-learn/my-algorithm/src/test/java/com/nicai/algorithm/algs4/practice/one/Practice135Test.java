package com.nicai.algorithm.algs4.practice.one;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Practice135Test
 *
 * @author guozhe
 * @date 2020/10/10
 */
public class Practice135Test {

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void print() {
        Practice135 practice135 = new Practice135();
        practice135.print(50);
        Assert.assertTrue(systemOutRule.getLog().contains("110010"));
    }
}