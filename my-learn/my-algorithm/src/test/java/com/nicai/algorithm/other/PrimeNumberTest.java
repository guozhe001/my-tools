package com.nicai.algorithm.other;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * PrimeNumberTest
 *
 * @author guozhe
 * @date 2020/09/30
 */
@Slf4j
public class PrimeNumberTest {

    @Tested
    private PrimeNumber primeNumber;

    /**
     * 素数
     */
    private static final List<Integer> PRIME_NUMBERS = Lists.newArrayList(2, 3, 5, 7, 11, 13, 17, 31);
    /**
     * 合数
     */
    private static final List<Integer> COMPOSITE_NUMBERS = Lists.newArrayList(4, 6, 8, 9, 10, 100, 1200, 1840, 3599);

    @Test
    public void isPrimeNumber() {
        PRIME_NUMBERS.forEach(num -> invokeAndAssert(num, Boolean.TRUE));
    }

    @Test
    public void notPrimeNumber() {
        COMPOSITE_NUMBERS.forEach(num -> invokeAndAssert(num, Boolean.FALSE));
    }

    @Test
    public void fermatTestFalse() {
        COMPOSITE_NUMBERS.forEach(num -> Assert.assertFalse(primeNumber.fermatTest(num)));
    }

    @Test
    public void fermatTestTrue() {
        PRIME_NUMBERS.forEach(num -> Assert.assertTrue(primeNumber.fermatTest(num)));
    }

    @Test
    public void primeNumberFeature() {
        PRIME_NUMBERS.forEach(num ->
        {
            if (num < 11) {
                primeNumber.primeNumberFeature(num);
            }
        });
        Assert.assertTrue(true);
    }

    private void invokeAndAssert(int num, boolean expect) {
        Assert.assertEquals(expect, primeNumber.isPrimeNumber(num));
        log.info("num ={} is{} primeNumber", num, expect ? "" : " not");
    }

}