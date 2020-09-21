package com.nicai.algorithm.other;

import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 欧几里得最大公约数算法测试
 *
 * @author guozhe
 * @date 2020/09/21
 */
@RunWith(JMockit.class)
public class EuclideanGreatestCommonDivisorTest {

    @Tested
    private EuclideanGreatestCommonDivisor euclideanGreatestCommonDivisor;

    @Test
    public void gcd() {
        int gcd = euclideanGreatestCommonDivisor.gcd(1112, 695);
        Assert.assertEquals(139, gcd);
    }

    @Test
    public void gcd1() {
        int gcd = euclideanGreatestCommonDivisor.gcd(1112, 1112);
        Assert.assertEquals(1112, gcd);
    }

    @Test
    public void gcd2() {
        Assert.assertThrows(IllegalArgumentException.class, () -> euclideanGreatestCommonDivisor.gcd(1112, 0));
    }
}