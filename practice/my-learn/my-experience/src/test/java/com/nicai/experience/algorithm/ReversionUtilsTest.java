package com.nicai.experience.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class ReversionUtilsTest {

    @Test
    public void intReversion() {
        int result = ReversionUtils.intReversion(123);
        Assert.assertEquals(321, result);
    }

    @Test
    public void intReversion0() {
        int result = ReversionUtils.intReversion(1230);
        Assert.assertEquals(321, result);
    }

    /**
     * 应不应该支持此种类型的反转呢？
     */
    @Test
    public void intReversion2() {
        int result = ReversionUtils.intReversion(01230);
        log.info("result={}", result);
        Assert.assertTrue(result > 0);
    }


    @Test(expected = IllegalArgumentException.class)

    public void intReversion1() {
        int i = ReversionUtils.intReversion(-1230);
    }

    @Test
    public void pow() {
        Assert.assertEquals(100, ReversionUtils.pow(10, 2));
    }

    @Test
    public void getDigits() {
        int digits = ReversionUtils.getDigits(123232);
        Assert.assertEquals(6, digits);
    }

    @Test
    public void getDigits1() {
        int digits = ReversionUtils.getDigits(32320);
        Assert.assertEquals(5, digits);
    }

    @Test
    public void getDigits0() {
        int digits = ReversionUtils.getDigits(03232);
        Assert.assertEquals(4, digits);
    }

}