package com.nicai.algorithm.aha.sum;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class SumTest {

    private static final Sum[] SUMS = new Sum[]{new SumOne(), new SumTwo()};

    @Test
    public void sum() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(new int[]{});
            Assert.assertEquals(0, sum);
        }
    }

    @Test
    public void sum1() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(new int[]{1});
            Assert.assertEquals(1, sum);
        }
    }

    @Test
    public void sum2() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(new int[]{1, 2});
            Assert.assertEquals(3, sum);
        }
    }

    @Test
    public void sum3() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(new int[]{1, 2, 3});
            Assert.assertEquals(6, sum);
        }

    }


    @Test
    public void sum4() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(IntStream.range(0, 100).toArray());
            Assert.assertEquals(4950, sum);
        }

    }


    @Test
    public void sum5() {
        for (Sum sumImpl : SUMS) {
            try {
                sumImpl.sum(IntStream.range(0, 100000).toArray());
                Assert.assertTrue("期待StackOverflowError没有发生", false);
            } catch (StackOverflowError e) {
                Assert.assertTrue(true);
            }
        }
    }

    @Test
    public void sum6() {
        for (Sum sumImpl : SUMS) {
            int sum = sumImpl.sum(new int[]{Integer.MAX_VALUE, 1, 2});
            Assert.assertTrue(sum < 0);
        }
    }

}