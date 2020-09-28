package com.nicai.algorithm.algs4.practice;

import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

/**
 * ParenthesesTest
 *
 * @author guozhe
 * @date 2020/09/28
 */
public class ParenthesesTest {

    @Tested
    private Parentheses parentheses;

    @Test
    public void check() {
        Assert.assertTrue(parentheses.check("{([]){}[()]}"));
    }
}