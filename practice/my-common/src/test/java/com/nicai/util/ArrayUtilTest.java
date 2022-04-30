package com.nicai.util;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020/08/19
 */
@Slf4j
public class ArrayUtilTest {

    @Test
    public void randomIntArray() {
        final int length = 10;
        IntStream.range(0, length).forEach(i -> {
            int[] nums = ArrayUtil.randomIntArray(length);
            log.info("randomIntArray={}", nums);
            Assert.assertEquals(length, nums.length);
            Arrays.stream(nums).forEach(num -> Assert.assertTrue(num < length));
        });
    }

    @Test
    public void randomNotRepeatIntArray() {
        final int length = 100;
        IntStream.range(0, length).forEach(i -> {
            int[] nums = ArrayUtil.randomNotRepeatIntArray(length);
            log.info("randomNotRepeatIntArray={}", nums);
            // 值小于1000
            Arrays.stream(nums).forEach(num -> Assert.assertTrue(num < length));
            HashSet<Integer> integers = Sets.newHashSet();
            Arrays.stream(nums).forEach(integers::add);
            // 不重复
            Assert.assertEquals(integers.size(), nums.length);
        });
    }

    @Test
    public void isSorted() {
        Assert.assertTrue(ArrayUtil.isSorted(new Integer[] { 0, 1, 2, 3, 4, 5 }));
    }

    @Test
    public void isSorted0() {
        Assert.assertTrue(ArrayUtil.isSorted(new int[] { 0, 1, 2, 3, 4, 5 }));
    }

    @Test
    public void isSorted1() {
        Assert.assertFalse(ArrayUtil.isSorted(new Integer[] { 0, 1, 2, 3, 4, 5, 1 }));
    }
}