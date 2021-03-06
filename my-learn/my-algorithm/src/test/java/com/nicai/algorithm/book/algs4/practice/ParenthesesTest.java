package com.nicai.algorithm.book.algs4.practice;

import com.nicai.algorithm.book.algs4.practice.one.Parentheses;
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
    public void checkExpectTrue() {
        Assert.assertTrue(parentheses.check("{([]){}[()]}"));
    }

    @Test
    public void checkExpectFalse1() {
        Assert.assertFalse(parentheses.check("{([}){}[()]}"));
    }

    @Test
    public void checkExpectFalse() {
        Assert.assertFalse(parentheses.check("{{([]){}[()]}"));
    }
}